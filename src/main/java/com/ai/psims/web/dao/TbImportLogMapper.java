package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbImportLog;
import com.ai.psims.web.model.TbImportLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImportLogMapper {
    int countByExample(TbImportLogExample example);

    int deleteByExample(TbImportLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbImportLog record);

    int insertSelective(TbImportLog record);

    List<TbImportLog> selectByExample(TbImportLogExample example);

    TbImportLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbImportLog record, @Param("example") TbImportLogExample example);

    int updateByExample(@Param("record") TbImportLog record, @Param("example") TbImportLogExample example);

    int updateByPrimaryKeySelective(TbImportLog record);

    int updateByPrimaryKey(TbImportLog record);
}