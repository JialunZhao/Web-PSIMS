package com.ai.psims.web.business.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.model.Customer;
import com.ai.psims.web.service.ICustomerService;

@Service
public class CustomerBusinesImpl implements ICustomerBusiness {
	@Resource(name = "customerServiceImpl")
	private ICustomerService customerService;

	@Override
	public int customeradd(Customer Customeradd) {
		// 新增客户信息业务
		
		return customerService.insertCustomerinfo(Customeradd);
	}

}
