package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbPrivilegeLog;
import com.ai.psims.web.model.TbPrivilegeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPrivilegeLogMapper {
    int countByExample(TbPrivilegeLogExample example);

    int deleteByExample(TbPrivilegeLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbPrivilegeLog record);

    int insertSelective(TbPrivilegeLog record);

    List<TbPrivilegeLog> selectByExample(TbPrivilegeLogExample example);

    TbPrivilegeLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbPrivilegeLog record, @Param("example") TbPrivilegeLogExample example);

    int updateByExample(@Param("record") TbPrivilegeLog record, @Param("example") TbPrivilegeLogExample example);

    int updateByPrimaryKeySelective(TbPrivilegeLog record);

    int updateByPrimaryKey(TbPrivilegeLog record);
}