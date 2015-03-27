package com.ai.psims.web.dao;

import com.ai.psims.web.model.Inportback;

public interface InportbackMapper {
    int deleteByPrimaryKey(String importbackSerialNumber);

    int insert(Inportback record);

    int insertSelective(Inportback record);

    Inportback selectByPrimaryKey(String importbackSerialNumber);

    int updateByPrimaryKeySelective(Inportback record);

    int updateByPrimaryKey(Inportback record);
}