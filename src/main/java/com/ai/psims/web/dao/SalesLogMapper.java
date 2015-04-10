package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesLog;
import com.ai.psims.web.model.SalesLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesLogMapper {
    int countByExample(SalesLogExample example);

    int deleteByExample(SalesLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SalesLog record);

    int insertSelective(SalesLog record);

    List<SalesLog> selectByExample(SalesLogExample example);

    SalesLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SalesLog record, @Param("example") SalesLogExample example);

    int updateByExample(@Param("record") SalesLog record, @Param("example") SalesLogExample example);

    int updateByPrimaryKeySelective(SalesLog record);

    int updateByPrimaryKey(SalesLog record);
}