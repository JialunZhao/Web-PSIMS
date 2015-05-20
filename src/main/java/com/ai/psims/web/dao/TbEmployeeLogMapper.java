package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbEmployeeLog;
import com.ai.psims.web.model.TbEmployeeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEmployeeLogMapper {
    int countByExample(TbEmployeeLogExample example);

    int deleteByExample(TbEmployeeLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbEmployeeLog record);

    int insertSelective(TbEmployeeLog record);

    List<TbEmployeeLog> selectByExample(TbEmployeeLogExample example);

    TbEmployeeLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbEmployeeLog record, @Param("example") TbEmployeeLogExample example);

    int updateByExample(@Param("record") TbEmployeeLog record, @Param("example") TbEmployeeLogExample example);

    int updateByPrimaryKeySelective(TbEmployeeLog record);

    int updateByPrimaryKey(TbEmployeeLog record);
}