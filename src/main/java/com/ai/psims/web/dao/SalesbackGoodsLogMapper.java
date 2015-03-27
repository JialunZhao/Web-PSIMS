package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackGoodsLog;

public interface SalesbackGoodsLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SalesbackGoodsLog record);

    int insertSelective(SalesbackGoodsLog record);

    SalesbackGoodsLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SalesbackGoodsLog record);

    int updateByPrimaryKey(SalesbackGoodsLog record);
}