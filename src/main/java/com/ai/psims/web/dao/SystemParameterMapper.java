package com.ai.psims.web.dao;

import com.ai.psims.web.model.SystemParameter;
import com.ai.psims.web.model.SystemParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParameterMapper {
    int countByExample(SystemParameterExample example);

    int deleteByExample(SystemParameterExample example);

    int deleteByPrimaryKey(Integer paramId);

    int insert(SystemParameter record);

    int insertSelective(SystemParameter record);

    List<SystemParameter> selectByExample(SystemParameterExample example);

    SystemParameter selectByPrimaryKey(Integer paramId);

    int updateByExampleSelective(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByExample(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByPrimaryKeySelective(SystemParameter record);

    int updateByPrimaryKey(SystemParameter record);
}