package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.GoodsMapper;
import com.ai.psims.web.dao.TbGoodsLogMapper;
import com.ai.psims.web.dao.TbGoodsMapper;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;
import com.ai.psims.web.model.TbGoodsLog;
import com.ai.psims.web.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Resource(name = "goodsMapper")
	private GoodsMapper goodsMapper;

	@Resource(name = "tbGoodsMapper")
	private TbGoodsMapper tbGoodsMapper;

	@Resource(name = "tbGoodsLogMapper")
	private TbGoodsLogMapper tbGoodsLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(GoodsServiceImpl.class);
	
	
	public List<Goods> selectByExample(GoodsExample example) {
		return goodsMapper.selectByExample(example);
	}

	@Override
	public Goods selectByKey(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
	
	//////////////////////////////
	
	@Override
	public int insertGoodsInfo(TbGoods goodsaddinfo) {
		logger.info("insertGoodsInfo");
		return tbGoodsMapper.insert(goodsaddinfo);
	}

	@Override
	public List<TbGoods> queryGoods(TbGoodsExample tbGoodsExample) {
		logger.info("queryGoods");
		List<TbGoods> goodssList = null;
		goodssList = tbGoodsMapper.selectByExample(tbGoodsExample);
		return goodssList;
	}

	@Override
	public int deleteGoodsInfo(TbGoods goodsDelete) {
		// 商品失效服务。
		logger.info("deleteGoodsInfo");
		goodsDelete.setGoodsEndtime(new Date());
		return tbGoodsMapper.updateByPrimaryKeySelective(goodsDelete);
	}

	@Override
	public int modifyGoodsInfo(TbGoods goodsModify) {
		// 商品修改服务。
		logger.info("modifyGoodsInfo");
		goodsModify.setGoodsModifytime(new Date());
		return tbGoodsMapper.updateByPrimaryKeySelective(goodsModify);
	}

	@Override
	public int backupGoodsInfo(TbGoods goodsBackup) {
		//商品备份方法
		logger.info("backDeleteGoodsInfo");
		// 1.备份数据
		// 1.1获取需备份数据内容。
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		tbGoodsExample.createCriteria().andGoodsIdEqualTo(
				goodsBackup.getGoodsId());
		List<TbGoods> tbGoodsbackup = tbGoodsMapper
				.selectByExample(tbGoodsExample);
		// 1.2备份到LOG表
		TbGoodsLog tbGoodsLog = new TbGoodsLog();
		tbGoodsLog.setLogDatetime(new Date());
		tbGoodsLog.setGoodsId(tbGoodsbackup.get(0).getGoodsId());
		tbGoodsLog.setGoodsName(tbGoodsbackup.get(0).getGoodsName());
		tbGoodsLog.setGoodsCode(tbGoodsbackup.get(0).getGoodsCode());
		tbGoodsLog.setGoodsVersion(tbGoodsbackup.get(0).getGoodsVersion());
		tbGoodsLog.setGoodsUnit(tbGoodsbackup.get(0).getGoodsUnit());
		tbGoodsLog.setGoodsBarCode(tbGoodsbackup.get(0).getGoodsBarCode());
		tbGoodsLog.setGoodsCurrentStock(tbGoodsbackup.get(0).getGoodsCurrentStock());
		tbGoodsLog.setGoodsTotalStock(tbGoodsbackup.get(0).getGoodsTotalStock());
		tbGoodsLog.setGoodsProductionDate(tbGoodsbackup.get(0).getGoodsProductionDate());
		tbGoodsLog.setGoodsExpirationDate(tbGoodsbackup.get(0).getGoodsExpirationDate());
		tbGoodsLog.setGoodsShelfLife(tbGoodsbackup.get(0).getGoodsShelfLife());
		tbGoodsLog.setGoodsProfit(tbGoodsbackup.get(0).getGoodsProfit());
		tbGoodsLog.setGoodsPrice(tbGoodsbackup.get(0).getGoodsPrice());
		tbGoodsLog.setGoodsDiscountAmount(tbGoodsbackup.get(0).getGoodsDiscountAmount());
		tbGoodsLog.setGoodsType(tbGoodsbackup.get(0).getGoodsType());
		tbGoodsLog.setGoodsStatus(tbGoodsbackup.get(0).getGoodsStatus());
		tbGoodsLog.setGoodsCreatetime(tbGoodsbackup.get(0).getGoodsCreatetime());
		tbGoodsLog.setGoodsModifytime(tbGoodsbackup.get(0).getGoodsModifytime());
		tbGoodsLog.setGoodsEndtime(tbGoodsbackup.get(0).getGoodsEndtime());
		tbGoodsLog.setProviderId(tbGoodsbackup.get(0).getProviderId());
		tbGoodsLog.setProviderName(tbGoodsbackup.get(0).getProviderName());
		tbGoodsLog.setProviderCode(tbGoodsbackup.get(0).getProviderCode());
		tbGoodsLog.setRemark(tbGoodsbackup.get(0).getRemark());
		tbGoodsLog.setGoodsDiscount(tbGoodsbackup.get(0).getGoodsDiscount());
		tbGoodsLog.setQuarterRebate(tbGoodsbackup.get(0).getQuarterRebate());
		tbGoodsLog.setAnnualRebate(tbGoodsbackup.get(0).getAnnualRebate());
		tbGoodsLog.setProviderSubsidy(tbGoodsbackup.get(0).getProviderSubsidy());
		tbGoodsLog.setProviderPackageSubsidy(tbGoodsbackup.get(0).getProviderPackageSubsidy());
		tbGoodsLog.setCustomerSubsidy(tbGoodsbackup.get(0).getCustomerSubsidy());
		tbGoodsLog.setOtherSubsidy(tbGoodsbackup.get(0).getOtherSubsidy());
		tbGoodsLog.setGoodsActualCost(tbGoodsbackup.get(0).getGoodsActualCost());
		tbGoodsLog.setStorageWarning(tbGoodsbackup.get(0).getStorageWarning());
		tbGoodsLog.setShelfLifeWarning(tbGoodsbackup.get(0).getShelfLifeWarning());
		return tbGoodsLogMapper.insert(tbGoodsLog);
	}
	
}
