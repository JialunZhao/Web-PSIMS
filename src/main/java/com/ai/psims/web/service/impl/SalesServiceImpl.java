package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesMapper;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.service.ISalesService;

@Service
public class SalesServiceImpl implements ISalesService {
	@Resource(name = "salesMapper")
	private SalesMapper salesMapper;

	@Override
	public int insertSelective(Sales sales) {
		return salesMapper.insertSelective(sales);
	}

	@Override
	public String selectSalesSerialNumber(String salesSerialNumber) {
		return salesMapper.selectSalesSerialNumber(salesSerialNumber);
	}

	@Override
	public List<Sales> selectByExample(SalesExample example) {
		return salesMapper.selectByExample(example);
	}

	@Override
	public Sales selectByKey(String salesSerialNumber) {
		return salesMapper.selectByPrimaryKey(salesSerialNumber);
	}

}
