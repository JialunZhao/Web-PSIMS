package com.ai.psims.web.dao;

import com.ai.psims.web.model.StorehouseLog;

public interface StorehouseLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(StorehouseLog record);

    int insertSelective(StorehouseLog record);

    StorehouseLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(StorehouseLog record);

    int updateByPrimaryKey(StorehouseLog record);
}