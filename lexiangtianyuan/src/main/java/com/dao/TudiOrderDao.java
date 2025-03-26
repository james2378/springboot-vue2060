package com.dao;

import com.entity.TudiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TudiOrderView;

/**
 * 土地租赁订单 Dao 接口
 *
 * @author 
 */
public interface TudiOrderDao extends BaseMapper<TudiOrderEntity> {

   List<TudiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
