package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackLog;

public interface SalesbackLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SalesbackLog record);

    int insertSelective(SalesbackLog record);

    SalesbackLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SalesbackLog record);

    int updateByPrimaryKey(SalesbackLog record);
}