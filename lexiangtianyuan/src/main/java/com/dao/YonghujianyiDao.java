package com.dao;

import com.entity.YonghujianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghujianyiView;

/**
 * 用户建议 Dao 接口
 *
 * @author 
 */
public interface YonghujianyiDao extends BaseMapper<YonghujianyiEntity> {

   List<YonghujianyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
