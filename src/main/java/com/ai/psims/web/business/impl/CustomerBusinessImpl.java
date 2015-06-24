package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.service.ICustomerService;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.service.ISystemParameterService;

@Service
public class CustomerBusinessImpl implements ICustomerBusiness {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerBusinessImpl.class);

	@Resource(name = "customerServiceImpl")
	private ICustomerService customerServiceImpl;

	@Resource(name = "employeeServiceImpl")
	private IEmployeeService employeeServiceImpl;

	@Resource(name = "systemParameterServiceImpl")
	private ISystemParameterService systemParameterServiceImpl;

	@Override
	public List<TbCustomer> customerQuery(TbCustomerExample customerQuery) {
		// 查询客户信息业务
		logger.info("customerQuery");
		return customerServiceImpl.queryCustomer(customerQuery);
	}

	@Override
	public int customerAdd(TbCustomer customerAdd) {
		// 新增客户信息业务
		logger.info("customerAdd");
		// 补全业务员信息
		TbEmployee tbEmployee = new TbEmployee();
		tbEmployee = employeeServiceImpl.selectByPrimaryKey(customerAdd
				.getEmployeeId());
		customerAdd.setEmployeeCode(tbEmployee.getEmployeeCode());
		customerAdd.setEmployeeName(tbEmployee.getEmployeeName());
		// 补全结账信息
		TbSystemParameter tbSystemParameter = new TbSystemParameter();
		tbSystemParameter = systemParameterServiceImpl.getSysById(Integer
				.parseInt(customerAdd.getCheckoutCode()));
		customerAdd.setCheckoutName(tbSystemParameter.getPpValue());
		return customerServiceImpl.insertCustomerInfo(customerAdd);
	}

	@Override
	public int customerDelete(TbCustomer customerDelete) {
		// 删除客户信息业务
		customerServiceImpl.backupCustomerInfo(customerDelete);
		logger.info("customerDelete");
		return customerServiceImpl.deleteCustomerInfo(customerDelete);
	}

	@Override
	public int customerModify(TbCustomer customerModify) {
		// 修改客户信息业务
		customerServiceImpl.backupCustomerInfo(customerModify);
		logger.info("customerModify");
		// 补全业务员信息
		TbEmployee tbEmployee = employeeServiceImpl
				.selectByPrimaryKey(customerModify.getEmployeeId());
		customerModify.setEmployeeCode(tbEmployee.getEmployeeCode());
		customerModify.setEmployeeName(tbEmployee.getEmployeeName());
		// 补全结账信息
		TbSystemParameter tbSystemParameter = new TbSystemParameter();
		tbSystemParameter = systemParameterServiceImpl.getSysById(Integer
				.parseInt(customerModify.getCheckoutCode()));
		customerModify.setCheckoutName(tbSystemParameter.getPpValue());

		return customerServiceImpl.modifyCustomerInfo(customerModify);
	}

	@Override
	public TbCustomer customerById(Integer customerId) {
		logger.info("customerById");
		return customerServiceImpl.selectCustomerInfo(customerId);
	}

}
