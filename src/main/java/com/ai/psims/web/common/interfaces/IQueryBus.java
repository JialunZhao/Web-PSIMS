package com.ai.psims.web.common.interfaces;

import java.util.List;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStorehouse;

public interface IQueryBus {
	public List<TbProvider> queryProvider();

	public List<TbStorehouse> queryStorehouse();

	public List<Goods> queryGoodsByName(GoodsExample example);

	public List<Employee> queryEmployee(EmployeeExample employeeExample);

	public List<TbCustomer> queryCustomer(TbCustomerExample customerExample);

	public List<TbImport> queryImport(TbImportExample example);
}
