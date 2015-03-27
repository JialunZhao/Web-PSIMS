package com.ai.psims.web.dao;

import com.ai.psims.web.model.EmployeeLog;

public interface EmployeeLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(EmployeeLog record);

    int insertSelective(EmployeeLog record);

    EmployeeLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(EmployeeLog record);

    int updateByPrimaryKey(EmployeeLog record);
}