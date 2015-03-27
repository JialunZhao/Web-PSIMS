package com.ai.psims.web.dao;

import com.ai.psims.web.model.GoodsLog;

public interface GoodsLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(GoodsLog record);

    int insertSelective(GoodsLog record);

    GoodsLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(GoodsLog record);

    int updateByPrimaryKey(GoodsLog record);
}