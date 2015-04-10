package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportGoodsLog;
import com.ai.psims.web.model.ImportGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportGoodsLogMapper {
    int countByExample(ImportGoodsLogExample example);

    int deleteByExample(ImportGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(ImportGoodsLog record);

    int insertSelective(ImportGoodsLog record);

    List<ImportGoodsLog> selectByExample(ImportGoodsLogExample example);

    ImportGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") ImportGoodsLog record, @Param("example") ImportGoodsLogExample example);

    int updateByExample(@Param("record") ImportGoodsLog record, @Param("example") ImportGoodsLogExample example);

    int updateByPrimaryKeySelective(ImportGoodsLog record);

    int updateByPrimaryKey(ImportGoodsLog record);
}