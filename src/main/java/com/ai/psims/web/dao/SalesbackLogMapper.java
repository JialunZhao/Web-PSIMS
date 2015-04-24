package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackLog;
import com.ai.psims.web.model.SalesbackLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesbackLogMapper {
    int countByExample(SalesbackLogExample example);

    int deleteByExample(SalesbackLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SalesbackLog record);

    int insertSelective(SalesbackLog record);

    List<SalesbackLog> selectByExample(SalesbackLogExample example);

    SalesbackLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SalesbackLog record, @Param("example") SalesbackLogExample example);

    int updateByExample(@Param("record") SalesbackLog record, @Param("example") SalesbackLogExample example);

    int updateByPrimaryKeySelective(SalesbackLog record);

    int updateByPrimaryKey(SalesbackLog record);
}