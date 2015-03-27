package com.ai.psims.web.dao;

import com.ai.psims.web.model.Sales;

public interface SalesMapper {
    int deleteByPrimaryKey(String salesSerialNumber);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(String salesSerialNumber);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}