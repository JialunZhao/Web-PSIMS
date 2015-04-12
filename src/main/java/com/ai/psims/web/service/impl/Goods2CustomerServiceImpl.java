package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbGoods2customerLogMapper;
import com.ai.psims.web.dao.TbGoods2customerMapper;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import com.ai.psims.web.service.IGoods2CustomerService;

@Service
public class Goods2CustomerServiceImpl implements IGoods2CustomerService {

	@Resource(name = "tbGoods2customerMapper")
	private TbGoods2customerMapper tbGoods2customerMapper;

	@Resource(name = "tbGoods2customerLogMapper")
	private TbGoods2customerLogMapper tbGoods2customerLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(Goods2CustomerServiceImpl.class);

	// @Override
	// public int backupGoodsInfo(TbGoods goodsBackup) {
	// //商品备份方法
	// logger.info("backDeleteGoodsInfo");
	// // 1.备份数据
	// // 1.1获取需备份数据内容。
	// TbGoodsExample tbGoodsExample = new TbGoodsExample();
	// tbGoodsExample.createCriteria().andGoodsIdEqualTo(
	// goodsBackup.getGoodsId());
	// List<TbGoods> tbGoodsbackup = tbGoodsMapper
	// .selectByExample(tbGoodsExample);
	// // 1.2备份到LOG表
	// TbGoodsLog tbGoodsLog = new TbGoodsLog();
	// tbGoodsLog.setLogDatetime(new Date());
	// tbGoodsLog.setGoodsId(tbGoodsbackup.get(0).getGoodsId());
	// tbGoodsLog.setGoodsName(tbGoodsbackup.get(0).getGoodsName());
	// tbGoodsLog.setGoodsCode(tbGoodsbackup.get(0).getGoodsCode());
	// tbGoodsLog.setGoodsVersion(tbGoodsbackup.get(0).getGoodsVersion());
	// tbGoodsLog.setGoodsUnit(tbGoodsbackup.get(0).getGoodsUnit());
	// tbGoodsLog.setGoodsCurrentStock(tbGoodsbackup.get(0).getGoodsCurrentStock());
	// tbGoodsLog.setGoodsTotalStock(tbGoodsbackup.get(0).getGoodsTotalStock());
	// tbGoodsLog.setGoodsProductionDate(tbGoodsbackup.get(0).getGoodsProductionDate());
	// tbGoodsLog.setGoodsExpirationDate(tbGoodsbackup.get(0).getGoodsExpirationDate());
	// tbGoodsLog.setGoodsShelfLife(tbGoodsbackup.get(0).getGoodsShelfLife());
	// tbGoodsLog.setGoodsProfit(tbGoodsbackup.get(0).getGoodsProfit());
	// tbGoodsLog.setGoodsPrice(tbGoodsbackup.get(0).getGoodsPrice());
	// tbGoodsLog.setGoodsDiscountAmount(tbGoodsbackup.get(0).getGoodsDiscountAmount());
	// tbGoodsLog.setGoodsType(tbGoodsbackup.get(0).getGoodsType());
	// tbGoodsLog.setGoodsStatus(tbGoodsbackup.get(0).getGoodsStatus());
	// tbGoodsLog.setGoodsCreatetime(tbGoodsbackup.get(0).getGoodsCreatetime());
	// tbGoodsLog.setGoodsModifytime(tbGoodsbackup.get(0).getGoodsModifytime());
	// tbGoodsLog.setGoodsEndtime(tbGoodsbackup.get(0).getGoodsEndtime());
	// tbGoodsLog.setProviderId(tbGoodsbackup.get(0).getProviderId());
	// tbGoodsLog.setProviderName(tbGoodsbackup.get(0).getProviderName());
	// tbGoodsLog.setProviderCode(tbGoodsbackup.get(0).getProviderCode());
	// tbGoodsLog.setRemark(tbGoodsbackup.get(0).getRemark());
	// tbGoodsLog.setGoodsDiscount(tbGoodsbackup.get(0).getGoodsDiscount());
	// tbGoodsLog.setQuarterRebate(tbGoodsbackup.get(0).getQuarterRebate());
	// tbGoodsLog.setAnnualRebate(tbGoodsbackup.get(0).getAnnualRebate());
	// tbGoodsLog.setProviderSubsidy(tbGoodsbackup.get(0).getProviderSubsidy());
	// tbGoodsLog.setProviderPackageSubsidy(tbGoodsbackup.get(0).getProviderPackageSubsidy());
	// tbGoodsLog.setCustomerSubsidy(tbGoodsbackup.get(0).getCustomerSubsidy());
	// tbGoodsLog.setOtherSubsidy(tbGoodsbackup.get(0).getOtherSubsidy());
	// tbGoodsLog.setGoodsActualCost(tbGoodsbackup.get(0).getGoodsActualCost());
	// tbGoodsLog.setStoragePrewarning(tbGoodsbackup.get(0).getStoragePrewarning());
	// tbGoodsLog.setShelfLifePrewarning(tbGoodsbackup.get(0).getShelfLifePrewarning());
	// return tbGoodsLogMapper.insert(tbGoodsLog);
	// }

	@Override
	public List<TbGoods2customer> queryGoods2Customer(
			TbGoods2customerExample goods2CustomerQuery) {
		logger.info("------------1.商品与客户关系查询服务-------------");
		return null;
	}

}
