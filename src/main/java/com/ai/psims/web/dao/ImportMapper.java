package com.ai.psims.web.dao;

import java.util.List;
import java.util.Map;

import com.ai.psims.web.model.Import;

public interface ImportMapper {
    int deleteByPrimaryKey(String importSerialNumber);

    int insert(Import record);

    int insertSelective(Import record);

    Import selectByPrimaryKey(String importSerialNumber);
    
    List<Import> selectByColum(Map<String, String> m);
    
    String selectImportSerialNumber(String importSerialNumber);
    
    List<Import> selectAll();

    int updateByPrimaryKeySelective(Import record);

    int updateByPrimaryKey(Import record);
}