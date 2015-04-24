package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbImportGoodsLog;
import com.ai.psims.web.model.TbImportGoodsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImportGoodsLogMapper {
    int countByExample(TbImportGoodsLogExample example);

    int deleteByExample(TbImportGoodsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbImportGoodsLog record);

    int insertSelective(TbImportGoodsLog record);

    List<TbImportGoodsLog> selectByExample(TbImportGoodsLogExample example);

    TbImportGoodsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbImportGoodsLog record, @Param("example") TbImportGoodsLogExample example);

    int updateByExample(@Param("record") TbImportGoodsLog record, @Param("example") TbImportGoodsLogExample example);

    int updateByPrimaryKeySelective(TbImportGoodsLog record);

    int updateByPrimaryKey(TbImportGoodsLog record);
}