package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImportMapper {
    int countByExample(TbImportExample example);

    int deleteByExample(TbImportExample example);

    int deleteByPrimaryKey(String importSerialNumber);

    int insert(TbImport record);

    int insertSelective(TbImport record);

    List<TbImport> selectByExample(TbImportExample example);

    TbImport selectByPrimaryKey(String importSerialNumber);
    
    String getImportSerialNumber(String importSerialNumber);

    int updateByExampleSelective(@Param("record") TbImport record, @Param("example") TbImportExample example);

    int updateByExample(@Param("record") TbImport record, @Param("example") TbImportExample example);

    int updateByPrimaryKeySelective(TbImport record);

    int updateByPrimaryKey(TbImport record);
}