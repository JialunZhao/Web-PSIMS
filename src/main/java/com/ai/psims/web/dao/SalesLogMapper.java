package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesLog;

public interface SalesLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SalesLog record);

    int insertSelective(SalesLog record);

    SalesLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SalesLog record);

    int updateByPrimaryKey(SalesLog record);
}