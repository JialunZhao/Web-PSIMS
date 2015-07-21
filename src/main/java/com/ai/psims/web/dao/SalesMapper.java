package com.ai.psims.web.dao;

import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.TbSales;
import com.ai.psims.web.model.TbSalesKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
    int countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteBySerialNumber(String salesSerialNumber);

    int deleteByPrimaryKey(TbSalesKey key);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectBySerialNumber(String salesSerialNumber);

    Sales selectByPrimaryKey(TbSalesKey key);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

	String selectSalesSerialNumber(String salesSerialNumber);
}