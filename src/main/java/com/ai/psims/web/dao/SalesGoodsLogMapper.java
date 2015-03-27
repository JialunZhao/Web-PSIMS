package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesGoodsLog;

public interface SalesGoodsLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SalesGoodsLog record);

    int insertSelective(SalesGoodsLog record);

    SalesGoodsLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SalesGoodsLog record);

    int updateByPrimaryKey(SalesGoodsLog record);
}