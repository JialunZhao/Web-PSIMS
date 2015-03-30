package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.CustomerMapper;
import com.ai.psims.web.model.Customer;
import com.ai.psims.web.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Resource(name = "customerMapper")
	private CustomerMapper customerMapper;

	@Override
	public int insertCustomerinfo(Customer customeraddinfo) {
		return customerMapper.insert(customeraddinfo);
	}

}
