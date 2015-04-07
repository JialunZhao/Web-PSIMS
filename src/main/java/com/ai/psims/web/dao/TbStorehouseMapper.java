package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStorehouseMapper {
    int countByExample(TbStorehouseExample example);

    int deleteByExample(TbStorehouseExample example);

    int deleteByPrimaryKey(Integer storehouseId);

    int insert(TbStorehouse record);

    int insertSelective(TbStorehouse record);

    List<TbStorehouse> selectByExample(TbStorehouseExample example);

    TbStorehouse selectByPrimaryKey(Integer storehouseId);

    int updateByExampleSelective(@Param("record") TbStorehouse record, @Param("example") TbStorehouseExample example);

    int updateByExample(@Param("record") TbStorehouse record, @Param("example") TbStorehouseExample example);

    int updateByPrimaryKeySelective(TbStorehouse record);

    int updateByPrimaryKey(TbStorehouse record);
}