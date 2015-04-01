package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbCustomerLog;
import com.ai.psims.web.model.TbCustomerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCustomerLogMapper {
    int countByExample(TbCustomerLogExample example);

    int deleteByExample(TbCustomerLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbCustomerLog record);

    int insertSelective(TbCustomerLog record);

    List<TbCustomerLog> selectByExample(TbCustomerLogExample example);

    TbCustomerLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbCustomerLog record, @Param("example") TbCustomerLogExample example);

    int updateByExample(@Param("record") TbCustomerLog record, @Param("example") TbCustomerLogExample example);

    int updateByPrimaryKeySelective(TbCustomerLog record);

    int updateByPrimaryKey(TbCustomerLog record);
}