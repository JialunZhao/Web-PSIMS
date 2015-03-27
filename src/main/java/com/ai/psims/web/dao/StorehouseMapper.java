package com.ai.psims.web.dao;

import java.util.List;

import com.ai.psims.web.model.Storehouse;

public interface StorehouseMapper {
    int deleteByPrimaryKey(Integer storehouseId);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(Integer storehouseId);
    
    List<Storehouse> select();

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);
}