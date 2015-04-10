package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportLog;
import com.ai.psims.web.model.ImportLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportLogMapper {
    int countByExample(ImportLogExample example);

    int deleteByExample(ImportLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(ImportLog record);

    int insertSelective(ImportLog record);

    List<ImportLog> selectByExample(ImportLogExample example);

    ImportLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") ImportLog record, @Param("example") ImportLogExample example);

    int updateByExample(@Param("record") ImportLog record, @Param("example") ImportLogExample example);

    int updateByPrimaryKeySelective(ImportLog record);

    int updateByPrimaryKey(ImportLog record);
}