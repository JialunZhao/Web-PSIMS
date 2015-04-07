package com.ai.psims.web.dao;

import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProviderMapper {
    int countByExample(TbProviderExample example);

    int deleteByExample(TbProviderExample example);

    int deleteByPrimaryKey(Integer providerId);

    int insert(TbProvider record);

    int insertSelective(TbProvider record);

    List<TbProvider> selectByExample(TbProviderExample example);

    TbProvider selectByPrimaryKey(Integer providerId);

    int updateByExampleSelective(@Param("record") TbProvider record, @Param("example") TbProviderExample example);

    int updateByExample(@Param("record") TbProvider record, @Param("example") TbProviderExample example);

    int updateByPrimaryKeySelective(TbProvider record);

    int updateByPrimaryKey(TbProvider record);
}