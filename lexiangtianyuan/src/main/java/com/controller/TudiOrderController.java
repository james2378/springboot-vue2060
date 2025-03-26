
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
 * 土地租赁订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tudiOrder")
public class TudiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(TudiOrderController.class);

    @Autowired
    private TudiOrderService tudiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private TudiService tudiService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private ShangjiaService shangjiaService;
@Autowired
private TudiCommentbackService tudiCommentbackService;



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
        PageUtils page = tudiOrderService.queryPage(params);

        //字典表数据转换
        List<TudiOrderView> list =(List<TudiOrderView>)page.getList();
        for(TudiOrderView c:list){
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
        TudiOrderEntity tudiOrder = tudiOrderService.selectById(id);
        if(tudiOrder !=null){
            //entity转view
            TudiOrderView view = new TudiOrderView();
            BeanUtils.copyProperties( tudiOrder , view );//把实体数据重构到view中

                //级联表
                TudiEntity tudi = tudiService.selectById(tudiOrder.getTudiId());
                if(tudi != null){
                    BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiId(tudi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(tudiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody TudiOrderEntity tudiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tudiOrder:{}",this.getClass().getName(),tudiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tudiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        tudiOrder.setInsertTime(new Date());
        tudiOrder.setCreateTime(new Date());
        tudiOrderService.insert(tudiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TudiOrderEntity tudiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tudiOrder:{}",this.getClass().getName(),tudiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            tudiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<TudiOrderEntity> queryWrapper = new EntityWrapper<TudiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TudiOrderEntity tudiOrderEntity = tudiOrderService.selectOne(queryWrapper);
        if(tudiOrderEntity==null){
            tudiOrderService.updateById(tudiOrder);//根据id更新
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
        tudiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TudiOrderEntity> tudiOrderList = new ArrayList<>();//上传的东西
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
                            TudiOrderEntity tudiOrderEntity = new TudiOrderEntity();
//                            tudiOrderEntity.setTudiOrderUuidNumber(data.get(0));                    //租赁单号 要改的
//                            tudiOrderEntity.setTudiId(Integer.valueOf(data.get(0)));   //土地 要改的
//                            tudiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tudiOrderEntity.setInsertTime(date);//时间
//                            tudiOrderEntity.setDaoqiTime(new Date(data.get(0)));          //到期时间 要改的
//                            tudiOrderEntity.setPingjiaTypes(Integer.valueOf(data.get(0)));   //是否评价 要改的
//                            tudiOrderEntity.setCreateTime(date);//时间
                            tudiOrderList.add(tudiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //租赁单号
                                if(seachFields.containsKey("tudiOrderUuidNumber")){
                                    List<String> tudiOrderUuidNumber = seachFields.get("tudiOrderUuidNumber");
                                    tudiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tudiOrderUuidNumber = new ArrayList<>();
                                    tudiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tudiOrderUuidNumber",tudiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //租赁单号
                        List<TudiOrderEntity> tudiOrderEntities_tudiOrderUuidNumber = tudiOrderService.selectList(new EntityWrapper<TudiOrderEntity>().in("tudi_order_uuid_number", seachFields.get("tudiOrderUuidNumber")));
                        if(tudiOrderEntities_tudiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TudiOrderEntity s:tudiOrderEntities_tudiOrderUuidNumber){
                                repeatFields.add(s.getTudiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [租赁单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tudiOrderService.insertBatch(tudiOrderList);
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
        PageUtils page = tudiOrderService.queryPage(params);

        //字典表数据转换
        List<TudiOrderView> list =(List<TudiOrderView>)page.getList();
        for(TudiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TudiOrderEntity tudiOrder = tudiOrderService.selectById(id);
            if(tudiOrder !=null){


                //entity转view
                TudiOrderView view = new TudiOrderView();
                BeanUtils.copyProperties( tudiOrder , view );//把实体数据重构到view中

                //级联表
                    TudiEntity tudi = tudiService.selectById(tudiOrder.getTudiId());
                if(tudi != null){
                    BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiId(tudi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tudiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody TudiOrderEntity tudiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tudiOrder:{}",this.getClass().getName(),tudiOrder.toString());
        TudiEntity tudiEntity = tudiService.selectById(tudiOrder.getTudiId());
        if(tudiEntity == null){
            return R.error(511,"查不到该土地");
        }
        // Double tudiNewMoney = tudiEntity.getTudiNewMoney();

        if(false){
        }
        else if(tudiEntity.getTudiNewMoney() == null){
            return R.error(511,"土地价格不能为空");
        }


        tudiEntity.setTudiZulinTypes(1);


        //计算所获得积分
        Double buyJifen =0.0;
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        if(yonghuEntity == null)
            return R.error(511,"用户不能为空");
        if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
        double balance = yonghuEntity.getNewMoney() - tudiEntity.getTudiNewMoney();//余额
        if(balance<0)
            return R.error(511,"余额不够支付");
        tudiOrder.setYonghuId(userId); //设置订单支付人id

        Date date = new Date();

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.MONTH,1);

        tudiOrder.setTudiOrderUuidNumber(String.valueOf(new Date().getTime()));
        tudiOrder.setPingjiaTypes(1);
        tudiOrder.setDaoqiTime(instance.getTime());



        ShangjiaEntity shangjiaEntity = shangjiaService.selectById(tudiEntity.getShangjiaId());
        if(shangjiaEntity == null)
            return  R.error("查不到农民");
        shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+tudiEntity.getTudiNewMoney());


        tudiOrder.setInsertTime(date);
        tudiOrder.setCreateTime(date);
        tudiOrderService.insert(tudiOrder);//新增订单
        yonghuEntity.setNewMoney(balance);//设置金额
        yonghuService.updateById(yonghuEntity);


        tudiService.updateById(tudiEntity);


        shangjiaService.updateById(shangjiaEntity);
        return R.ok();
    }


    /**
     * 续费
     */
    @RequestMapping("/xuzu")
    public R xuzu(Integer id, HttpServletRequest request){
        logger.debug("xuzu方法:,,Controller:{},,id:{}",this.getClass().getName(),id);


        TudiOrderEntity tudiOrder = tudiOrderService.selectById(id);
        TudiEntity tudiEntity = tudiService.selectById(tudiOrder.getTudiId());
        if(tudiEntity == null){
            return R.error(511,"查不到该土地");
        }
        // Double tudiNewMoney = tudiEntity.getTudiNewMoney();

        if(false){
        }
        else if(tudiEntity.getTudiNewMoney() == null){
            return R.error(511,"土地价格不能为空");
        }


        tudiEntity.setTudiZulinTypes(1);


        //计算所获得积分
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        if(yonghuEntity == null)
            return R.error(511,"用户不能为空");
        if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
        double balance = yonghuEntity.getNewMoney() - tudiEntity.getTudiNewMoney();//余额
        if(balance<0)
            return R.error(511,"余额不够支付");





//        tudiOrder.setYonghuId(userId); //设置订单支付人id

        Date date = new Date();

        Calendar instance = Calendar.getInstance();
        instance.setTime(tudiOrder.getDaoqiTime());
        instance.add(Calendar.MONTH,1);

//        tudiOrder.setTudiOrderUuidNumber(String.valueOf(new Date().getTime()));
//        tudiOrder.setPingjiaTypes(1);
        tudiOrder.setDaoqiTime(instance.getTime());



        ShangjiaEntity shangjiaEntity = shangjiaService.selectById(tudiEntity.getShangjiaId());
        if(shangjiaEntity == null)
            return  R.error("查不到农民");
        shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+tudiEntity.getTudiNewMoney());


//        tudiOrder.setInsertTime(date);
//        tudiOrder.setCreateTime(date);
        tudiOrderService.updateById(tudiOrder);//新增订单
        yonghuEntity.setNewMoney(balance);//设置金额
        yonghuService.updateById(yonghuEntity);


//        tudiService.updateById(tudiEntity);


        shangjiaService.updateById(shangjiaEntity);
        return R.ok();
    }


    /**
     * 评价
     */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, HttpServletRequest request) {
        logger.debug("commentback方法:,,Controller:{},,id:{}", this.getClass().getName(), id);

        TudiOrderEntity tudiOrderEntity = tudiOrderService.selectById(id);
        tudiOrderEntity.setPingjiaTypes(2);



        TudiCommentbackEntity tudiCommentbackEntity = new TudiCommentbackEntity<>();
        tudiCommentbackEntity.setTudiId(tudiOrderEntity.getTudiId());
        tudiCommentbackEntity.setTudiCommentbackText(commentbackText);
        tudiCommentbackEntity.setCreateTime(new Date());
        tudiCommentbackEntity.setInsertTime(new Date());
        tudiCommentbackEntity.setYonghuId(tudiOrderEntity.getYonghuId());
        tudiCommentbackService.insert(tudiCommentbackEntity);



        tudiOrderService.updateById(tudiOrderEntity);
        return R.ok();
    }


}
