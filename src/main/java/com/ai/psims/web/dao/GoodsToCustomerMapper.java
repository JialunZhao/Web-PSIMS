package com.ai.psims.web.dao;

import com.ai.psims.web.model.GoodsToCustomer;

public interface GoodsToCustomerMapper {
    int deleteByPrimaryKey(String goods2customerId);

    int insert(GoodsToCustomer record);

    int insertSelective(GoodsToCustomer record);

    GoodsToCustomer selectByPrimaryKey(String goods2customerId);

    int updateByPrimaryKeySelective(GoodsToCustomer record);

    int updateByPrimaryKey(GoodsToCustomer record);
}