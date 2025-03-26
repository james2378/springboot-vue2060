
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
 * 土地
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tudi")
public class TudiController {
    private static final Logger logger = LoggerFactory.getLogger(TudiController.class);

    @Autowired
    private TudiService tudiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangjiaService shangjiaService;

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
        params.put("tudiDeleteStart",1);params.put("tudiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = tudiService.queryPage(params);

        //字典表数据转换
        List<TudiView> list =(List<TudiView>)page.getList();
        for(TudiView c:list){
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
        TudiEntity tudi = tudiService.selectById(id);
        if(tudi !=null){
            //entity转view
            TudiView view = new TudiView();
            BeanUtils.copyProperties( tudi , view );//把实体数据重构到view中

                //级联表
                ShangjiaEntity shangjia = shangjiaService.selectById(tudi.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
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
    public R save(@RequestBody TudiEntity tudi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tudi:{}",this.getClass().getName(),tudi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("农民".equals(role))
            tudi.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TudiEntity> queryWrapper = new EntityWrapper<TudiEntity>()
            .eq("shangjia_id", tudi.getShangjiaId())
            .eq("tudi_name", tudi.getTudiName())
            .eq("tudi_address", tudi.getTudiAddress())
            .eq("tudi_types", tudi.getTudiTypes())
            .eq("tudi_shumu_types", tudi.getTudiShumuTypes())
            .eq("tudi_haohuai_types", tudi.getTudiHaohuaiTypes())
            .eq("tudi_clicknum", tudi.getTudiClicknum())
            .eq("tudi_zulin_types", tudi.getTudiZulinTypes())
            .eq("shangxia_types", tudi.getShangxiaTypes())
            .eq("tudi_delete", tudi.getTudiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiEntity tudiEntity = tudiService.selectOne(queryWrapper);
        if(tudiEntity==null){
            tudi.setTudiClicknum(1);
            tudi.setShangxiaTypes(1);
            tudi.setTudiDelete(1);
            tudi.setCreateTime(new Date());
            tudiService.insert(tudi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TudiEntity tudi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tudi:{}",this.getClass().getName(),tudi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("农民".equals(role))
//            tudi.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<TudiEntity> queryWrapper = new EntityWrapper<TudiEntity>()
            .notIn("id",tudi.getId())
            .andNew()
            .eq("shangjia_id", tudi.getShangjiaId())
            .eq("tudi_name", tudi.getTudiName())
            .eq("tudi_address", tudi.getTudiAddress())
            .eq("tudi_types", tudi.getTudiTypes())
            .eq("tudi_shumu_types", tudi.getTudiShumuTypes())
            .eq("tudi_haohuai_types", tudi.getTudiHaohuaiTypes())
            .eq("tudi_clicknum", tudi.getTudiClicknum())
            .eq("tudi_zulin_types", tudi.getTudiZulinTypes())
            .eq("shangxia_types", tudi.getShangxiaTypes())
            .eq("tudi_delete", tudi.getTudiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiEntity tudiEntity = tudiService.selectOne(queryWrapper);
        if("".equals(tudi.getTudiPhoto()) || "null".equals(tudi.getTudiPhoto())){
                tudi.setTudiPhoto(null);
        }
        if("".equals(tudi.getTudiFile()) || "null".equals(tudi.getTudiFile())){
                tudi.setTudiFile(null);
        }
        if(tudiEntity==null){
            tudiService.updateById(tudi);//根据id更新
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
        ArrayList<TudiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TudiEntity tudiEntity = new TudiEntity();
            tudiEntity.setId(id);
            tudiEntity.setTudiDelete(2);
            list.add(tudiEntity);
        }
        if(list != null && list.size() >0){
            tudiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TudiEntity> tudiList = new ArrayList<>();//上传的东西
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
                            TudiEntity tudiEntity = new TudiEntity();
//                            tudiEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //农民 要改的
//                            tudiEntity.setTudiName(data.get(0));                    //土地名称 要改的
//                            tudiEntity.setTudiPhoto("");//照片
//                            tudiEntity.setTudiFile(data.get(0));                    //合同 要改的
//                            tudiEntity.setTudiAddress(data.get(0));                    //所在地址 要改的
//                            tudiEntity.setTudiTypes(Integer.valueOf(data.get(0)));   //土地类型 要改的
//                            tudiEntity.setTudiShumuTypes(Integer.valueOf(data.get(0)));   //有无树 要改的
//                            tudiEntity.setTudiHaohuaiTypes(Integer.valueOf(data.get(0)));   //土地状态 要改的
//                            tudiEntity.setTudiOldMoney(data.get(0));                    //土地原价/月 要改的
//                            tudiEntity.setTudiNewMoney(data.get(0));                    //现价/月 要改的
//                            tudiEntity.setTudiClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            tudiEntity.setTudiContent("");//照片
//                            tudiEntity.setTudiZulinTypes(Integer.valueOf(data.get(0)));   //是否租赁 要改的
//                            tudiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            tudiEntity.setTudiDelete(1);//逻辑删除字段
//                            tudiEntity.setCreateTime(date);//时间
                            tudiList.add(tudiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tudiService.insertBatch(tudiList);
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
        PageUtils page = tudiService.queryPage(params);

        //字典表数据转换
        List<TudiView> list =(List<TudiView>)page.getList();
        for(TudiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TudiEntity tudi = tudiService.selectById(id);
            if(tudi !=null){

                //点击数量加1
                tudi.setTudiClicknum(tudi.getTudiClicknum()+1);
                tudiService.updateById(tudi);

                //entity转view
                TudiView view = new TudiView();
                BeanUtils.copyProperties( tudi , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(tudi.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
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
    public R add(@RequestBody TudiEntity tudi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tudi:{}",this.getClass().getName(),tudi.toString());
        Wrapper<TudiEntity> queryWrapper = new EntityWrapper<TudiEntity>()
            .eq("shangjia_id", tudi.getShangjiaId())
            .eq("tudi_name", tudi.getTudiName())
            .eq("tudi_address", tudi.getTudiAddress())
            .eq("tudi_types", tudi.getTudiTypes())
            .eq("tudi_shumu_types", tudi.getTudiShumuTypes())
            .eq("tudi_haohuai_types", tudi.getTudiHaohuaiTypes())
            .eq("tudi_clicknum", tudi.getTudiClicknum())
            .eq("tudi_zulin_types", tudi.getTudiZulinTypes())
            .eq("shangxia_types", tudi.getShangxiaTypes())
            .eq("tudi_delete", tudi.getTudiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiEntity tudiEntity = tudiService.selectOne(queryWrapper);
        if(tudiEntity==null){
            tudi.setTudiDelete(1);
            tudi.setCreateTime(new Date());
        tudiService.insert(tudi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
