package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.service.ICustomerService;

@Service
public class CustomerBusinessImpl implements ICustomerBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerBusinessImpl.class);
	
	@Resource(name = "customerServiceImpl")
	private ICustomerService customerService;

	@Override
	public List<TbCustomer> customerQuery(TbCustomerExample customerQuery) {
		// 查询客户信息业务
		logger.info("customerQuery");
		return customerService.queryCustomer(customerQuery);
	}

	@Override
	public int customerAdd(TbCustomer customerAdd) {
		// 新增客户信息业务
		logger.info("customerAdd");
		return customerService.insertCustomerInfo(customerAdd);
	}

	@Override
	public int customerDelete(TbCustomer customerDelete) {
		// 删除客户信息业务
		customerService.backupCustomerInfo(customerDelete);
		logger.info("customerDelete");
		return customerService.deleteCustomerInfo(customerDelete);
	}

	@Override
	public int customerModify(TbCustomer customerModify) {
		// 修改客户信息业务
		customerService.backupCustomerInfo(customerModify);
		logger.info("customerModify");
		return customerService.modifyCustomerInfo(customerModify);
	}

}
