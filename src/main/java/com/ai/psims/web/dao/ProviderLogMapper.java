package com.ai.psims.web.dao;

import com.ai.psims.web.model.ProviderLog;

public interface ProviderLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(ProviderLog record);

    int insertSelective(ProviderLog record);

    ProviderLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(ProviderLog record);

    int updateByPrimaryKey(ProviderLog record);
}