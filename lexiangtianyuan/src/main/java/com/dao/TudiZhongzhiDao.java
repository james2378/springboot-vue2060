package com.dao;

import com.entity.TudiZhongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TudiZhongzhiView;

/**
 * 种植详情 Dao 接口
 *
 * @author 
 */
public interface TudiZhongzhiDao extends BaseMapper<TudiZhongzhiEntity> {

   List<TudiZhongzhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
