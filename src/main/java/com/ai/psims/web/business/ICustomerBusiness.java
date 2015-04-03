package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;

public interface ICustomerBusiness {
	public int customerAdd(TbCustomer customeradd);

	public int customerDelete(TbCustomer customerDelete);

	public int customerModify(TbCustomer customerModify);

	public List<TbCustomer> customerQuery(TbCustomerExample customerQuery);
}
