package com.ai.psims.web.dao;

import com.ai.psims.web.model.Salesback;

public interface SalesbackMapper {
    int deleteByPrimaryKey(String salesbackSerialNumber);

    int insert(Salesback record);

    int insertSelective(Salesback record);

    Salesback selectByPrimaryKey(String salesbackSerialNumber);

    int updateByPrimaryKeySelective(Salesback record);

    int updateByPrimaryKey(Salesback record);
}