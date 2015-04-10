package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesLogMapper;
import com.ai.psims.web.dao.SalesMapper;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesLog;
import com.ai.psims.web.service.ISalesService;

@Service
public class SalesServiceImpl implements ISalesService {
	@Resource(name = "salesMapper")
	private SalesMapper salesMapper;
	@Resource(name = "salesLogMapper")
	private SalesLogMapper salesLogMapper;

	@Override
	public int insertSelective(Sales sales) {
		return salesMapper.insert(sales);
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

	@Override
	public int updateSales(Sales sales) {
		insertToLog(sales);
		return salesMapper.updateByPrimaryKey(sales);
	}

	@Override
	public int updateSalesByKey(Sales sales) {
		insertToLog(sales);
		return salesMapper.updateByPrimaryKeySelective(sales);
	}

	@Override
	public int deleteSales(String salesSerialNumber) {
		Sales sales = new Sales();
		sales = salesMapper.selectByPrimaryKey(salesSerialNumber);
		insertToLog(sales);
		// 00-失效
		sales.setSalesStatus("00");
		return salesMapper.updateByPrimaryKeySelective(sales);
	}

	@Override
	public int insertToLog(Sales sales) {
		Sales sale = new Sales();
		sale = salesMapper.selectByPrimaryKey(sales.getSalesSerialNumber());
		SalesLog log = new SalesLog();

		log.setCustomerId(sale.getCustomerId());
		log.setCustomerName(sale.getCustomerName());
		log.setEmployeeId(sale.getEmployeeId());
		log.setEmployeeName(sale.getEmployeeName());
		log.setIncomeTime(sale.getIncomeTime());
		log.setIncomeType(sale.getIncomeType());
		log.setLogDatetime(new Date());
		log.setSalesDate(sale.getSalesDate());
		log.setSalesRemark(sale.getSalesRemark());
		log.setSalesSerialNumber(sale.getSalesSerialNumber());
		log.setSalesStatus(sale.getSalesStatus());
		log.setSalesTotalPrice(sale.getSalesTotalPrice());
		log.setSalesType(sale.getSalesType());
		log.setStorehouseId(sale.getStorehouseId());
		log.setStorehouseName(sale.getStorehouseName());
		log.setCreditCount(sale.getCreditCount());

		return salesLogMapper.insertSelective(log);
	}

}
