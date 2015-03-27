package com.ai.psims.web.dao;

import com.ai.psims.web.model.GoodsToCustomerLog;

public interface GoodsToCustomerLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(GoodsToCustomerLog record);

    int insertSelective(GoodsToCustomerLog record);

    GoodsToCustomerLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(GoodsToCustomerLog record);

    int updateByPrimaryKey(GoodsToCustomerLog record);
}