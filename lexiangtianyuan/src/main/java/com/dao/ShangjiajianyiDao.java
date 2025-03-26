package com.dao;

import com.entity.ShangjiajianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjiajianyiView;

/**
 * 农民建议 Dao 接口
 *
 * @author 
 */
public interface ShangjiajianyiDao extends BaseMapper<ShangjiajianyiEntity> {

   List<ShangjiajianyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
