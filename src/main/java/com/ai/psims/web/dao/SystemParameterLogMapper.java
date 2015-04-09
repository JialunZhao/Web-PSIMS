package com.ai.psims.web.dao;

import com.ai.psims.web.model.SystemParameterLog;
import com.ai.psims.web.model.SystemParameterLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParameterLogMapper {
    int countByExample(SystemParameterLogExample example);

    int deleteByExample(SystemParameterLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SystemParameterLog record);

    int insertSelective(SystemParameterLog record);

    List<SystemParameterLog> selectByExample(SystemParameterLogExample example);

    SystemParameterLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SystemParameterLog record, @Param("example") SystemParameterLogExample example);

    int updateByExample(@Param("record") SystemParameterLog record, @Param("example") SystemParameterLogExample example);

    int updateByPrimaryKeySelective(SystemParameterLog record);

    int updateByPrimaryKey(SystemParameterLog record);
}