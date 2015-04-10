package com.ai.psims.web.dao;

import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ImportMapper {
    int countByExample(ImportExample example);

    int deleteByExample(ImportExample example);

    int deleteByPrimaryKey(String importSerialNumber);

    int insert(Import record);

    int insertSelective(Import record);

    List<Import> selectByExample(ImportExample example);

    Import selectByPrimaryKey(String importSerialNumber);
    
    String getImportSerialNumber(String importSerialNumber);

    int updateByExampleSelective(@Param("record") Import record, @Param("example") ImportExample example);

    int updateByExample(@Param("record") Import record, @Param("example") ImportExample example);

    int updateByPrimaryKeySelective(Import record);

    int updateByPrimaryKey(Import record);
}