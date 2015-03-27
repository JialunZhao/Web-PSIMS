package com.ai.psims.web.dao;

import com.ai.psims.web.model.SystemParameter;

public interface SystemParameterMapper {
    int deleteByPrimaryKey(Integer paramId);

    int insert(SystemParameter record);

    int insertSelective(SystemParameter record);

    SystemParameter selectByPrimaryKey(Integer paramId);

    int updateByPrimaryKeySelective(SystemParameter record);

    int updateByPrimaryKey(SystemParameter record);
}