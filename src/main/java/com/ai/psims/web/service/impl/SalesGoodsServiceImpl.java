package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesGoodsLogMapper;
import com.ai.psims.web.dao.SalesGoodsMapper;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.SalesGoodsLog;
import com.ai.psims.web.service.ISalesGoodsService;

@Service
public class SalesGoodsServiceImpl implements ISalesGoodsService {
	@Resource(name = "salesGoodsMapper")
	private SalesGoodsMapper salesGoodsMapper;
	@Resource(name = "salesGoodsLogMapper")
	private SalesGoodsLogMapper salesGoodsLogMapper;

	@Override
	public int insertSelective(SalesGoods salesGoods) {
		return salesGoodsMapper.insert(salesGoods);
	}

	@Override
	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example) {
		return salesGoodsMapper.selectByExample(example);
	}

	@Override
	public SalesGoods selectSalesGoodsByKey(Integer salesGoodsId) {
		return salesGoodsMapper.selectByPrimaryKey(salesGoodsId);
	}

	@Override
	public int updateSalesGoods(SalesGoods salesGoods) {
		insertToLog(salesGoods);
		return salesGoodsMapper.updateByPrimaryKey(salesGoods);
	}

	@Override
	public int updateSalesGoodsByKey(SalesGoods salesGoods) {
		insertToLog(salesGoods);
		return salesGoodsMapper.updateByPrimaryKeySelective(salesGoods);
	}

	@Override
	public int deleteByPrimaryKey(Integer salesGoodsId) {
		SalesGoods salesGoods = new SalesGoods();
		salesGoods = salesGoodsMapper.selectByPrimaryKey(salesGoodsId);
		insertToLog(salesGoods);
		salesGoods.setSalesGoodsEndtime(new Date());
		return salesGoodsMapper.updateByPrimaryKeySelective(salesGoods);
	}

	@Override
	public int insertToLog(SalesGoods salesGoods) {
		SalesGoods salesGood = new SalesGoods();
		salesGood = salesGoodsMapper.selectByPrimaryKey(salesGoods
				.getSalesGoodsId());
		SalesGoodsLog log = new SalesGoodsLog();

		log.setGoodsId(salesGood.getGoodsId());
		log.setGoodsName(salesGood.getGoodsName());
		log.setLogDatetime(new Date());
		log.setSalesDiscountAmount(salesGood.getSalesDiscountAmount());
		log.setSalesFinalAmount(salesGood.getSalesFinalAmount());
		log.setSalesGoodsAmount(salesGood.getSalesGoodsAmount());
		log.setSalesGoodsCreatetime(salesGood.getSalesGoodsCreatetime());
		log.setSalesGoodsEndtime(salesGood.getSalesGoodsEndtime());
		log.setSalesGoodsExpirationDate(salesGood.getSalesGoodsExpirationDate());
		log.setSalesGoodsId(salesGood.getSalesGoodsId());
		log.setSalesGoodsModifytime(salesGood.getSalesGoodsModifytime());
		log.setSalesGoodsPrice(salesGood.getSalesGoodsPrice());
		log.setSalesGoodsProductionDate(salesGood.getSalesGoodsProductionDate());
		log.setSalesGoodsRemark(salesGood.getSalesGoodsRemark());
		log.setSalesGoodsTotalPrice(salesGood.getSalesGoodsTotalPrice());
		log.setSalesGoodsType(salesGood.getSalesGoodsType());
		log.setSalesGoodsUnit(salesGood.getSalesGoodsUnit());
		log.setSalesSerialNumber(salesGood.getSalesSerialNumber());
		log.setStorageId(salesGood.getStorageId());

		return salesGoodsLogMapper.insertSelective(log);
	}

}
