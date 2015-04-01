package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.psims.web.dao.TbCustomerMapper;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.service.ICustomerService;

@Service
@Transactional(readOnly = false)
public class CustomerServiceImpl implements ICustomerService {
	@Resource(name = "tbCustomerMapper")
	private TbCustomerMapper tbCustomerMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerServiceImpl.class);
	
	@Override
	public int insertCustomerInfo(TbCustomer customeraddinfo) {
		logger.info("insertCustomerInfo");
		return tbCustomerMapper.insert(customeraddinfo);
	}

	@Override
	public List<TbCustomer> queryCustomer(TbCustomerExample tbCustomerExample) {
		logger.info("queryCustomer");
		List<TbCustomer> customersList = null;
		customersList = tbCustomerMapper.selectByExample(tbCustomerExample);
		return customersList;
	}

	@Override
	public int deleteCustomerInfo(TbCustomerExample customerDelete) {
		logger.info("deleteCustomerInfo");
		return tbCustomerMapper.deleteByExample(customerDelete);
	}

	@Override
	public int modifyCustomerInfo(TbCustomer customerModify) {
		logger.info("modifyCustomerInfo");
		return tbCustomerMapper.updateByPrimaryKeySelective(customerModify);
	}

}
