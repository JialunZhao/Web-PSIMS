package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IGoods2CustomerBusiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import com.ai.psims.web.service.ICustomerService;
import com.ai.psims.web.service.IGoods2CustomerService;
import com.ai.psims.web.service.IGoodsService;

@Service
public class Goods2CustomerBusinessImpl implements IGoods2CustomerBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Goods2CustomerBusinessImpl.class);
	
	@Resource(name = "goods2CustomerServiceImpl")
	private IGoods2CustomerService goods2CustomerService;

	@Resource(name = "customerServiceImpl")
	private ICustomerService customerService;
	
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;
	
	@Override
	public List<TbGoods2customer> goods2CustomerQuery(TbGoods2customerExample goods2CustomerQuery) {
		logger.info("------------1.商品与客户关系查询业务-------------");
		return goods2CustomerService.queryGoods2Customer(goods2CustomerQuery);
	}

	@Override
	public List<TbCustomer> customerListQuery(
			TbCustomerExample tbCustomerExample) {
		logger.info("------------1.商品与客户关系查询业务--查询客户列表业务-------------");
		return customerService.queryCustomer(tbCustomerExample);
	}

	@Override
	public int insertGoods2CustomerInfo(List<TbGoods2customer> tbGoods2customers) {
		logger.info("------------1.商品与客户关系新增保存业务-------------");
		int num = 0;
		for (int i = 0; i < tbGoods2customers.size(); i++) {
			TbGoods tbGoods = new TbGoods();
			tbGoods = goodsService.selectGoodsInfo(tbGoods2customers.get(i).getGoodsId());
			tbGoods2customers.get(i).setGoodsName(tbGoods.getGoodsName());
			tbGoods2customers.get(i).setGoodsCode(tbGoods.getGoodsCode());
			tbGoods2customers.get(i).setGoodsVersion(tbGoods.getGoodsVersion());
			tbGoods2customers.get(i).setGoodsUnit(tbGoods.getGoodsUnit());
			tbGoods2customers.get(i).setGoodsBarCode(tbGoods.getGoodsBarCode());
			tbGoods2customers.get(i).setGoodsShelfLife(tbGoods.getGoodsShelfLife());
			tbGoods2customers.get(i).setGoodsPrice(tbGoods.getGoodsPrice());
//			tbGoods2customers.get(i).setGoodsPrice(tbGoods.getGoodsPrice());
//			tbGoods2customers.get(i).setGoodsDiscount(tbGoods.getGoodsDiscount());
//			tbGoods2customers.get(i).setGoodsDiscountAmount(tbGoods.getGoodsDiscountAmount());
			tbGoods2customers.get(i).setGoodsType(tbGoods.getGoodsType());
//			tbGoods2customers.get(i).setGoodsStatus(tbGoods.getGoodsStatus());
			tbGoods2customers.get(i).setGoodsCreatetime(tbGoods.getGoodsCreatetime());
			tbGoods2customers.get(i).setGoodsModifytime(tbGoods.getGoodsModifytime());
			tbGoods2customers.get(i).setGoodsEndtime(tbGoods.getGoodsEndtime());
			tbGoods2customers.get(i).setProviderId(tbGoods.getProviderId());
			tbGoods2customers.get(i).setProviderName(tbGoods.getProviderName());
			tbGoods2customers.get(i).setProviderCode(tbGoods.getProviderCode());
			tbGoods2customers.get(i).setQuarterRebate(tbGoods.getQuarterRebate());
			tbGoods2customers.get(i).setAnnualRebate(tbGoods.getAnnualRebate());
			tbGoods2customers.get(i).setProviderSubsidy(tbGoods.getProviderSubsidy());
			tbGoods2customers.get(i).setProviderPackageSubsidy(tbGoods.getProviderPackageSubsidy());
			tbGoods2customers.get(i).setCustomerSubsidy(tbGoods.getCustomerSubsidy());
			tbGoods2customers.get(i).setOtherSubsidy(tbGoods.getOtherSubsidy());
			tbGoods2customers.get(i).setGoodsActualCost(tbGoods.getGoodsActualCost());
//			tbGoods2customers.get(i).setGoodsProfit(tbGoods.getGoodsProfit());
			tbGoods2customers.get(i).setRemark(tbGoods.getRemark());
			tbGoods2customers.get(i).setGoodsStatus("01");
			TbCustomer tbCustomer = new TbCustomer();
			tbCustomer = customerService.selectCustomerInfo(tbGoods2customers.get(i).getCustomerId());
			tbGoods2customers.get(i).setCustomerName(tbCustomer.getCustomerName());
			tbGoods2customers.get(i).setCustomerCode(tbCustomer.getCustomerCode());
			num = num + goods2CustomerService.insertGoods2CustomerInfo(tbGoods2customers.get(i));
		}
		logger.info("------------2.商品与客户关系新增保存业务完成-------------");

		return num;
	}

	@Override
	public int updateGoods2CustomerInfo(List<TbGoods2customer> tbGoods2customers) {
		logger.info("------------1.商品与客户关系新增更新业务-------------");
		int num = 0;
		for (int i = 0; i < tbGoods2customers.size(); i++) {
			tbGoods2customers.get(i).setGoodsStatus("01");
			goods2CustomerService.backupGoods2CustomerInfo(tbGoods2customers.get(i));
			num = num + goods2CustomerService.updateGoods2CustomerInfo(tbGoods2customers.get(i));
		}
		logger.info("------------2.商品与客户关系新增更新业务完成-------------");

		return num;
	}
	
	@Override
	public int deleteGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系新增更新业务-------------");
		int num = 0;
		tbGoods2customer.setGoodsStatus("00");
		goods2CustomerService.backupGoods2CustomerInfo(tbGoods2customer);
		num = num + goods2CustomerService.deleteGoods2CustomerInfo(tbGoods2customer);
		
		logger.info("------------2.商品与客户关系新增更新业务完成-------------");

		return num;
	}

}
