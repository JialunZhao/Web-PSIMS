package com.ai.psims.web.dao;

import com.ai.psims.web.model.CustomerLog;

public interface CustomerLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(CustomerLog record);

    int insertSelective(CustomerLog record);

    CustomerLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(CustomerLog record);

    int updateByPrimaryKey(CustomerLog record);
}