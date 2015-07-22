package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSalesLog;
import com.ai.psims.web.model.TbSalesLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSalesLogMapper {
    int countByExample(TbSalesLogExample example);

    int deleteByExample(TbSalesLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbSalesLog record);

    int insertSelective(TbSalesLog record);

    List<TbSalesLog> selectByExample(TbSalesLogExample example);

    TbSalesLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbSalesLog record, @Param("example") TbSalesLogExample example);

    int updateByExample(@Param("record") TbSalesLog record, @Param("example") TbSalesLogExample example);

    int updateByPrimaryKeySelective(TbSalesLog record);

    int updateByPrimaryKey(TbSalesLog record);
}