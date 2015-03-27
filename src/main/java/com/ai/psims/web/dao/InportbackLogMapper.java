package com.ai.psims.web.dao;

import com.ai.psims.web.model.InportbackLog;

public interface InportbackLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(InportbackLog record);

    int insertSelective(InportbackLog record);

    InportbackLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(InportbackLog record);

    int updateByPrimaryKey(InportbackLog record);
}