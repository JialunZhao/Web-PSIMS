package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;

public interface IGoods2CustomerBusiness {

	public List<TbGoods2customer> goods2CustomerQuery(
			TbGoods2customerExample goods2CustomerQuery);

	public List<TbCustomer> customerListQuery(
			TbCustomerExample tbCustomerExample);

	int insertGoods2CustomerInfo(List<TbGoods2customer> tbGoods2customers);

	int updateGoods2CustomerInfo(List<TbGoods2customer> tbGoods2customers); 

}
