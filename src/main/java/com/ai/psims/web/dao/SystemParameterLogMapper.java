package com.ai.psims.web.dao;

import com.ai.psims.web.model.SystemParameterLog;

public interface SystemParameterLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SystemParameterLog record);

    int insertSelective(SystemParameterLog record);

    SystemParameterLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SystemParameterLog record);

    int updateByPrimaryKey(SystemParameterLog record);
}