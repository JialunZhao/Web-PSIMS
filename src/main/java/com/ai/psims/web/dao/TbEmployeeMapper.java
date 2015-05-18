package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEmployeeMapper {
    int countByExample(TbEmployeeExample example);

    int deleteByExample(TbEmployeeExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(TbEmployee record);

    int insertSelective(TbEmployee record);

    List<TbEmployee> selectByExample(TbEmployeeExample example);

    TbEmployee selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByExample(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByPrimaryKeySelective(TbEmployee record);

    int updateByPrimaryKey(TbEmployee record);
}