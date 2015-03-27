package com.ai.psims.web.dao;

import java.util.List;

import com.ai.psims.web.model.Provider;

public interface ProviderMapper {
    int deleteByPrimaryKey(Integer providerId);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer providerId);
    
    List<Provider> select();

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
}