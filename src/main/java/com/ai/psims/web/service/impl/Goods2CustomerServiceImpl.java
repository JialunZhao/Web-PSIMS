package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbGoods2customerLogMapper;
import com.ai.psims.web.dao.TbGoods2customerMapper;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import com.ai.psims.web.model.TbGoods2customerLog;
import com.ai.psims.web.service.IGoods2CustomerService;

@Service
public class Goods2CustomerServiceImpl implements IGoods2CustomerService {

	@Resource(name = "tbGoods2customerMapper")
	private TbGoods2customerMapper tbGoods2customerMapper;

	@Resource(name = "tbGoods2customerLogMapper")
	private TbGoods2customerLogMapper tbGoods2customerLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(Goods2CustomerServiceImpl.class);

	@Override
	public List<TbGoods2customer> queryGoods2Customer(
			TbGoods2customerExample goods2CustomerQuery) {
		logger.info("------------1.商品与客户关系查询服务-------------");
		return tbGoods2customerMapper.selectByExample(goods2CustomerQuery);
	}

	@Override
	public int insertGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系保存服务-------------");
		return tbGoods2customerMapper.insert(tbGoods2customer);
	}

	@Override
	public int updateGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系更新服务-------------");
		return tbGoods2customerMapper.updateByPrimaryKeySelective(tbGoods2customer);
	}

	@Override
	public int backupGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系备份服务-------------");
		logger.info("------------2.获取商品与客户关系备份数据内容-------------");
		TbGoods2customerExample tbGoods2customerExample =new TbGoods2customerExample();
		tbGoods2customerExample.createCriteria().andGoods2customerIdEqualTo(tbGoods2customer.getGoods2customerId());
		List<TbGoods2customer> tbGoods2customers = tbGoods2customerMapper.selectByExample(tbGoods2customerExample);
		logger.info("------------3.备份商品与客户关系数据内容到LOG表-------------");
		TbGoods2customerLog tbGoods2customerLog =new TbGoods2customerLog();
		tbGoods2customerLog.setLogDatetime(new Date());
		tbGoods2customerLog.setGoods2customerId(tbGoods2customers.get(0).getGoods2customerId());
		tbGoods2customerLog.setGoodsId(tbGoods2customers.get(0).getGoodsId());
		tbGoods2customerLog.setGoodsName(tbGoods2customers.get(0).getGoodsName());
		tbGoods2customerLog.setGoodsCode(tbGoods2customers.get(0).getGoodsCode());
		tbGoods2customerLog.setCustomerId(tbGoods2customers.get(0).getCustomerId());
		tbGoods2customerLog.setCustomerName(tbGoods2customers.get(0).getCustomerName());
		tbGoods2customerLog.setCustomerCode(tbGoods2customers.get(0).getCustomerCode());
		tbGoods2customerLog.setGoodsVersion(tbGoods2customers.get(0).getGoodsVersion());
		tbGoods2customerLog.setGoodsUnit(tbGoods2customers.get(0).getGoodsUnit());
		tbGoods2customerLog.setGoodsBarCode(tbGoods2customers.get(0).getGoodsBarCode());
		tbGoods2customerLog.setGoodsShelfLife(tbGoods2customers.get(0).getGoodsShelfLife());
		tbGoods2customerLog.setGoodsPrice(tbGoods2customers.get(0).getGoodsPrice());
		tbGoods2customerLog.setGoodsDiscount(tbGoods2customers.get(0).getGoodsDiscount());
		tbGoods2customerLog.setGoodsPrizePoolRatio(tbGoods2customers.get(0).getGoodsPrizePoolRatio());
		tbGoods2customerLog.setGoodsType(tbGoods2customers.get(0).getGoodsType());
		tbGoods2customerLog.setGoodsStatus(tbGoods2customers.get(0).getGoodsStatus());
		tbGoods2customerLog.setGoodsCreatetime(tbGoods2customers.get(0).getGoodsCreatetime());
		tbGoods2customerLog.setGoodsModifytime(tbGoods2customers.get(0).getGoodsModifytime());
		tbGoods2customerLog.setGoodsEndtime(tbGoods2customers.get(0).getGoodsEndtime());
		tbGoods2customerLog.setProviderId(tbGoods2customers.get(0).getProviderId());
		tbGoods2customerLog.setProviderName(tbGoods2customers.get(0).getProviderName());
		tbGoods2customerLog.setProviderCode(tbGoods2customers.get(0).getProviderCode());
		tbGoods2customerLog.setQuarterRebate(tbGoods2customers.get(0).getQuarterRebate());
		tbGoods2customerLog.setAnnualRebate(tbGoods2customers.get(0).getAnnualRebate());
		tbGoods2customerLog.setProviderSubsidy(tbGoods2customers.get(0).getProviderSubsidy());
		tbGoods2customerLog.setProviderPackageSubsidy(tbGoods2customers.get(0).getProviderPackageSubsidy());
		tbGoods2customerLog.setCustomerSubsidy(tbGoods2customers.get(0).getCustomerSubsidy());
		tbGoods2customerLog.setOtherSubsidy(tbGoods2customers.get(0).getOtherSubsidy());
		tbGoods2customerLog.setGoodsActualCost(tbGoods2customers.get(0).getGoodsActualCost());
		tbGoods2customerLog.setGoodsProfit(tbGoods2customers.get(0).getGoodsProfit());
		tbGoods2customerLog.setRemark(tbGoods2customers.get(0).getRemark());

		return tbGoods2customerLogMapper.insertSelective(tbGoods2customerLog);
	}

	@Override
	public int deleteGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		tbGoods2customer.setGoodsStatus("00");
		return tbGoods2customerMapper.updateByPrimaryKey(tbGoods2customer);
	}
}
