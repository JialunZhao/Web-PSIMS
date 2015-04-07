package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;

public interface ISalesService {
	public int insertSelective(Sales sales);

	public String selectSalesSerialNumber(String salesSerialNumber);

	public List<Sales> selectByExample(SalesExample example);

	public Sales selectByKey(String salesSerialNumber);
}
