package com.ai.psims.web.common.interfaces;

import java.util.List;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbProvider;

public interface IQueryBus {
	public List<TbProvider> queryProvider();

	public List<Storehouse> queryStorehouse();

	public List<Goods> queryGoodsByName(GoodsExample example);
	
	public List<Employee> queryEmployee(EmployeeExample employeeExample);

	public List<TbCustomer> queryCustomer(TbCustomerExample customerExample);

	public List<Import> queryImport();
}
