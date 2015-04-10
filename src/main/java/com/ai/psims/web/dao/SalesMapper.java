package com.ai.psims.web.dao;

import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
    int countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(String salesSerialNumber);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(String salesSerialNumber);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

	String selectSalesSerialNumber(String salesSerialNumber);
}