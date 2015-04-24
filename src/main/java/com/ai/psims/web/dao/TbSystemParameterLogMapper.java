package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbSystemParameterLog;
import com.ai.psims.web.model.TbSystemParameterLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSystemParameterLogMapper {
    int countByExample(TbSystemParameterLogExample example);

    int deleteByExample(TbSystemParameterLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbSystemParameterLog record);

    int insertSelective(TbSystemParameterLog record);

    List<TbSystemParameterLog> selectByExample(TbSystemParameterLogExample example);

    TbSystemParameterLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbSystemParameterLog record, @Param("example") TbSystemParameterLogExample example);

    int updateByExample(@Param("record") TbSystemParameterLog record, @Param("example") TbSystemParameterLogExample example);

    int updateByPrimaryKeySelective(TbSystemParameterLog record);

    int updateByPrimaryKey(TbSystemParameterLog record);
}