package com.ai.psims.web.common.interfaces;

import java.util.List;

import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStorehouse;

public interface IQueryBus {
	public List<TbProvider> queryProvider();

	public TbProvider queryProviderById(Integer providerId);

	public List<TbStorehouse> queryStorehouse();

	public List<TbGoods> queryGoodsByName(TbGoodsExample example);

	public List<TbEmployee> queryEmployee(TbEmployeeExample employeeExample);

	public List<TbCustomer> queryCustomer(TbCustomerExample customerExample);

	public List<TbImport> queryImport(TbImportExample example);
}
