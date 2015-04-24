package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportbackLog;
import com.ai.psims.web.model.ImportbackLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportbackLogMapper {
    int countByExample(ImportbackLogExample example);

    int deleteByExample(ImportbackLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(ImportbackLog record);

    int insertSelective(ImportbackLog record);

    List<ImportbackLog> selectByExample(ImportbackLogExample example);

    ImportbackLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") ImportbackLog record, @Param("example") ImportbackLogExample example);

    int updateByExample(@Param("record") ImportbackLog record, @Param("example") ImportbackLogExample example);

    int updateByPrimaryKeySelective(ImportbackLog record);

    int updateByPrimaryKey(ImportbackLog record);
}