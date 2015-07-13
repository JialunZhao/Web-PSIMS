package com.ai.psims.web.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.dao.TbImportMapper;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;
import com.ai.psims.web.service.ICustomerService;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IProviderService;
import com.ai.psims.web.service.IStorehouseService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class QueryBus implements IQueryBus {
	@Resource(name = "providerServiceImpl")
	private IProviderService providerService;
	@Resource(name = "storehouseServiceImpl")
	private IStorehouseService storehouseService;
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;
	@Resource(name = "tbImportMapper")
	private TbImportMapper tbImportMapper;
	@Resource(name = "customerServiceImpl")
	private ICustomerService customerService;
	@Resource(name = "employeeServiceImpl")
	private IEmployeeService employeeService;

	public List<TbProvider> queryProvider() {
		List<TbProvider> tbProviders = new ArrayList<TbProvider>();
		TbProviderExample tbProviderExample = new TbProviderExample();
		TbProviderExample.Criteria criteria =tbProviderExample.createCriteria();
		criteria.andProviderStatusEqualTo("01");
		tbProviders = providerService.queryProvider(tbProviderExample);
		return tbProviders;
	}

	public List<TbStorehouse> queryStorehouse() {
		TbStorehouseExample example = new TbStorehouseExample();
		example.createCriteria().andEndtimeIsNull().andStatusEqualTo("01");
		return storehouseService.queryStorehouse(example);
	}

	public List<TbCustomer> queryCustomer(TbCustomerExample customerExample) {
		return customerService.queryCustomer(customerExample);
	}

	public List<TbEmployee> queryEmployee(TbEmployeeExample employeeExample) {
		return employeeService.selectByExample(employeeExample);
	}

	public List<TbGoods> queryGoodsByName(TbGoodsExample example) {
		return goodsService.queryGoods(example);
	}

	public List<TbImport> queryImport(TbImportExample example) {
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = tbImportMapper.selectByExample(example);
		for (TbImport import1 : importList) {
			import1.setImportStatus(CreateIdUtil.getTranslation(import1
					.getImportStatus()));
			import1.setPaymentType(CreateIdUtil.getTranslation(import1
					.getPaymentType()));
		}
		return importList;
	}

	@Override
	public TbProvider queryProviderById(Integer providerId) {
		TbProvider provider = new TbProvider();
		provider = providerService.selectProvider(providerId);
		return provider;
	}

}
