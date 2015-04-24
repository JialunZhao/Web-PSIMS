package com.ai.psims.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesbackLogMapper;
import com.ai.psims.web.dao.SalesbackMapper;
import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;
import com.ai.psims.web.model.SalesbackLog;
import com.ai.psims.web.service.ISalesbackService;

@Service
public class SalesbackServiceImpl implements ISalesbackService {
	@Resource(name = "salesbackMapper")
	private SalesbackMapper salesbackMapper;
	@Resource(name = "salesbackLogMapper")
	private SalesbackLogMapper salesbackLogMapper;

	@Override
	public int deleteByExample(SalesbackExample example) {
		List<Salesback> salesbacks = new ArrayList<Salesback>();
		salesbacks = salesbackMapper.selectByExample(example);
		for (Salesback salesback : salesbacks) {
			insertToLog(salesback);
			salesback.setSalesbackType("00");
			salesbackMapper.updateByPrimaryKeySelective(salesback);
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String salesbackSerialNumber) {
		Salesback salesback = new Salesback();
		salesback = salesbackMapper.selectByPrimaryKey(salesbackSerialNumber);
		insertToLog(salesback);
		salesback.setSalesbackType("00");
		return salesbackMapper.updateByPrimaryKeySelective(salesback);
	}

	@Override
	public int insert(Salesback record) {
		return salesbackMapper.insert(record);
	}

	@Override
	public int insertByKey(Salesback record) {
		return salesbackMapper.insertSelective(record);
	}

	@Override
	public List<Salesback> selectByExample(SalesbackExample example) {
		return salesbackMapper.selectByExample(example);
	}

	@Override
	public Salesback selectByPrimaryKey(String salesbackSerialNumber) {
		return salesbackMapper.selectByPrimaryKey(salesbackSerialNumber);
	}

	@Override
	public int updateByPrimaryKey(Salesback record) {
		insertToLog(record);
		return salesbackMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Salesback record) {
		insertToLog(record);
		return salesbackMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertToLog(Salesback salesback) {
		Salesback salesba = new Salesback();
		salesba = salesbackMapper.selectByPrimaryKey(salesback
				.getSalesbackSerialNumber());
		SalesbackLog log = new SalesbackLog();

		log.setCustomerId(salesba.getCustomerId());
		log.setCustomerName(salesba.getCustomerName());
		log.setEmployeeId(salesba.getEmployeeId());
		log.setEmployeeName(salesba.getEmployeeName());
		log.setLogDatetime(new Date());
		log.setSalesbackReason(salesba.getSalesbackReason());
		log.setSalesbackRefund(salesba.getSalesbackRefund());
		log.setSalesbackRefundTime(salesba.getSalesbackRefundTime());
		log.setSalesbackRefundType(salesba.getSalesbackRefundType());
		log.setSalesbackRemark(salesba.getSalesbackRemark());
		log.setSalesbackSerialNumber(salesba.getSalesbackSerialNumber());
		log.setSalesbackTime(salesba.getSalesbackTime());
		log.setSalesbackType(salesba.getSalesbackType());
		log.setSalesSerialNumber(salesba.getSalesSerialNumber());
		log.setStorehouseId(salesba.getStorehouseId());
		log.setStorehouseName(salesba.getStorehouseName());

		return salesbackLogMapper.insert(log);
	}

	@Override
	public String getSalesbackSerialNumber(String salesbackSerialNumber) {
		return salesbackMapper.selectSalesSerialNumber(salesbackSerialNumber);
	}

}
