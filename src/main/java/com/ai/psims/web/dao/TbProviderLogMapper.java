package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbProviderLog;
import com.ai.psims.web.model.TbProviderLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProviderLogMapper {
    int countByExample(TbProviderLogExample example);

    int deleteByExample(TbProviderLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TbProviderLog record);

    int insertSelective(TbProviderLog record);

    List<TbProviderLog> selectByExample(TbProviderLogExample example);

    TbProviderLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TbProviderLog record, @Param("example") TbProviderLogExample example);

    int updateByExample(@Param("record") TbProviderLog record, @Param("example") TbProviderLogExample example);

    int updateByPrimaryKeySelective(TbProviderLog record);

    int updateByPrimaryKey(TbProviderLog record);
}