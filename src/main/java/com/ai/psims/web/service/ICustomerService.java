package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;

public interface ICustomerService {

	public int insertCustomerInfo(TbCustomer customerAdd);

	public int deleteCustomerInfo(TbCustomer customerDelete);

	public int modifyCustomerInfo(TbCustomer customerModify);
	
	public List<TbCustomer> queryCustomer(TbCustomerExample customerQuery);

	public TbCustomer selectCustomerInfo(Integer customerId);
	
	public int backupCustomerInfo(TbCustomer customerBackup);

	public int backupCustomerInfoByPrimaryKey(Integer customerId);

}
