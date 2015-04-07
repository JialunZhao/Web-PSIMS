package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbStorehouseLog;
import com.ai.psims.web.model.TbStorehouseLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStorehouseLogMapper {
    int countByExample(TbStorehouseLogExample example);

    int deleteByExample(TbStorehouseLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbStorehouseLog record);

    int insertSelective(TbStorehouseLog record);

    List<TbStorehouseLog> selectByExample(TbStorehouseLogExample example);

    TbStorehouseLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbStorehouseLog record, @Param("example") TbStorehouseLogExample example);

    int updateByExample(@Param("record") TbStorehouseLog record, @Param("example") TbStorehouseLogExample example);

    int updateByPrimaryKeySelective(TbStorehouseLog record);

    int updateByPrimaryKey(TbStorehouseLog record);
}