
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 种植详情
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tudiZhongzhi")
public class TudiZhongzhiController {
    private static final Logger logger = LoggerFactory.getLogger(TudiZhongzhiController.class);

    @Autowired
    private TudiZhongzhiService tudiZhongzhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangjiaService shangjiaService;
    @Autowired
    private TudiOrderService tudiOrderService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("农民".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = tudiZhongzhiService.queryPage(params);

        //字典表数据转换
        List<TudiZhongzhiView> list =(List<TudiZhongzhiView>)page.getList();
        for(TudiZhongzhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TudiZhongzhiEntity tudiZhongzhi = tudiZhongzhiService.selectById(id);
        if(tudiZhongzhi !=null){
            //entity转view
            TudiZhongzhiView view = new TudiZhongzhiView();
            BeanUtils.copyProperties( tudiZhongzhi , view );//把实体数据重构到view中

                //级联表
                ShangjiaEntity shangjia = shangjiaService.selectById(tudiZhongzhi.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
                //级联表
                TudiOrderEntity tudiOrder = tudiOrderService.selectById(tudiZhongzhi.getTudiOrderId());
                if(tudiOrder != null){
                    BeanUtils.copyProperties( tudiOrder , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiOrderId(tudiOrder.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TudiZhongzhiEntity tudiZhongzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tudiZhongzhi:{}",this.getClass().getName(),tudiZhongzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("农民".equals(role))
            tudiZhongzhi.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TudiZhongzhiEntity> queryWrapper = new EntityWrapper<TudiZhongzhiEntity>()
            .eq("tudi_order_id", tudiZhongzhi.getTudiOrderId())
            .eq("shangjia_id", tudiZhongzhi.getShangjiaId())
            .eq("tudi_zhongzhi_name", tudiZhongzhi.getTudiZhongzhiName())
            .eq("tudi_zhongzhi_video", tudiZhongzhi.getTudiZhongzhiVideo())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiZhongzhiEntity tudiZhongzhiEntity = tudiZhongzhiService.selectOne(queryWrapper);
        if(tudiZhongzhiEntity==null){
            tudiZhongzhi.setInsertTime(new Date());
            tudiZhongzhi.setCreateTime(new Date());
            tudiZhongzhiService.insert(tudiZhongzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TudiZhongzhiEntity tudiZhongzhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tudiZhongzhi:{}",this.getClass().getName(),tudiZhongzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("农民".equals(role))
//            tudiZhongzhi.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<TudiZhongzhiEntity> queryWrapper = new EntityWrapper<TudiZhongzhiEntity>()
            .notIn("id",tudiZhongzhi.getId())
            .andNew()
            .eq("tudi_order_id", tudiZhongzhi.getTudiOrderId())
            .eq("shangjia_id", tudiZhongzhi.getShangjiaId())
            .eq("tudi_zhongzhi_name", tudiZhongzhi.getTudiZhongzhiName())
            .eq("tudi_zhongzhi_video", tudiZhongzhi.getTudiZhongzhiVideo())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiZhongzhiEntity tudiZhongzhiEntity = tudiZhongzhiService.selectOne(queryWrapper);
        if("".equals(tudiZhongzhi.getTudiZhongzhiPhoto()) || "null".equals(tudiZhongzhi.getTudiZhongzhiPhoto())){
                tudiZhongzhi.setTudiZhongzhiPhoto(null);
        }
        if("".equals(tudiZhongzhi.getTudiZhongzhiVideo()) || "null".equals(tudiZhongzhi.getTudiZhongzhiVideo())){
                tudiZhongzhi.setTudiZhongzhiVideo(null);
        }
        if(tudiZhongzhiEntity==null){
            tudiZhongzhiService.updateById(tudiZhongzhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tudiZhongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TudiZhongzhiEntity> tudiZhongzhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TudiZhongzhiEntity tudiZhongzhiEntity = new TudiZhongzhiEntity();
//                            tudiZhongzhiEntity.setTudiOrderId(Integer.valueOf(data.get(0)));   //土地订单 要改的
//                            tudiZhongzhiEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tudiZhongzhiEntity.setTudiZhongzhiName(data.get(0));                    //标题 要改的
//                            tudiZhongzhiEntity.setTudiZhongzhiPhoto("");//照片
//                            tudiZhongzhiEntity.setTudiZhongzhiVideo(data.get(0));                    //视频 要改的
//                            tudiZhongzhiEntity.setTudiZhongzhiContent("");//照片
//                            tudiZhongzhiEntity.setInsertTime(date);//时间
//                            tudiZhongzhiEntity.setCreateTime(date);//时间
                            tudiZhongzhiList.add(tudiZhongzhiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tudiZhongzhiService.insertBatch(tudiZhongzhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = tudiZhongzhiService.queryPage(params);

        //字典表数据转换
        List<TudiZhongzhiView> list =(List<TudiZhongzhiView>)page.getList();
        for(TudiZhongzhiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TudiZhongzhiEntity tudiZhongzhi = tudiZhongzhiService.selectById(id);
            if(tudiZhongzhi !=null){


                //entity转view
                TudiZhongzhiView view = new TudiZhongzhiView();
                BeanUtils.copyProperties( tudiZhongzhi , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(tudiZhongzhi.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
                //级联表
                    TudiOrderEntity tudiOrder = tudiOrderService.selectById(tudiZhongzhi.getTudiOrderId());
                if(tudiOrder != null){
                    BeanUtils.copyProperties( tudiOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiOrderId(tudiOrder.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TudiZhongzhiEntity tudiZhongzhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tudiZhongzhi:{}",this.getClass().getName(),tudiZhongzhi.toString());
        Wrapper<TudiZhongzhiEntity> queryWrapper = new EntityWrapper<TudiZhongzhiEntity>()
            .eq("tudi_order_id", tudiZhongzhi.getTudiOrderId())
            .eq("shangjia_id", tudiZhongzhi.getShangjiaId())
            .eq("tudi_zhongzhi_name", tudiZhongzhi.getTudiZhongzhiName())
            .eq("tudi_zhongzhi_video", tudiZhongzhi.getTudiZhongzhiVideo())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiZhongzhiEntity tudiZhongzhiEntity = tudiZhongzhiService.selectOne(queryWrapper);
        if(tudiZhongzhiEntity==null){
            tudiZhongzhi.setInsertTime(new Date());
            tudiZhongzhi.setCreateTime(new Date());
        tudiZhongzhiService.insert(tudiZhongzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
