package com.ai.psims.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesbackGoodsLogMapper;
import com.ai.psims.web.dao.SalesbackGoodsMapper;
import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;
import com.ai.psims.web.model.SalesbackGoodsLog;
import com.ai.psims.web.service.ISalesbackGoodsService;

@Service
public class SalesbackGoodsServiceImpl implements ISalesbackGoodsService {
	@Resource(name = "salesbackGoodsMapper")
	private SalesbackGoodsMapper salesbackGoodsMapper;
	@Resource(name = "salesbackGoodsLogMapper")
	private SalesbackGoodsLogMapper salesbackGoodsLogMapper;

	@Override
	public int deleteByExample(SalesbackGoodsExample example) {
		List<SalesbackGoods> salesbacks = new ArrayList<SalesbackGoods>();
		salesbacks = salesbackGoodsMapper.selectByExample(example);
		for (SalesbackGoods salesback : salesbacks) {
			insertToLog(salesback);
			salesback.setEndtime(new Date());
			salesbackGoodsMapper.updateByPrimaryKeySelective(salesback);
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer salesbackGoodsId) {
		SalesbackGoods salesbackGoods = salesbackGoodsMapper
				.selectByPrimaryKey(salesbackGoodsId);
		insertToLog(salesbackGoods);
		salesbackGoods.setEndtime(new Date());
		return salesbackGoodsMapper.updateByPrimaryKey(salesbackGoods);
	}

	@Override
	public int insert(SalesbackGoods record) {
		return salesbackGoodsMapper.insert(record);
	}

	@Override
	public int insertSelective(SalesbackGoods record) {
		return salesbackGoodsMapper.insertSelective(record);
	}

	@Override
	public List<SalesbackGoods> selectByExample(SalesbackGoodsExample example) {
		return salesbackGoodsMapper.selectByExample(example);
	}

	@Override
	public SalesbackGoods selectByPrimaryKey(Integer salesbackGoodsId) {
		return salesbackGoodsMapper.selectByPrimaryKey(salesbackGoodsId);
	}

	@Override
	public int updateByPrimaryKey(SalesbackGoods record) {
		insertToLog(record);
		return salesbackGoodsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(SalesbackGoods record) {
		insertToLog(record);
		return salesbackGoodsMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertToLog(SalesbackGoods salesbackGoods) {
		SalesbackGoods salesbackGood = new SalesbackGoods();
		salesbackGood = salesbackGoodsMapper.selectByPrimaryKey(salesbackGoods
				.getSalesbackGoodsId());
		SalesbackGoodsLog log = new SalesbackGoodsLog();

		log.setCreatetime(salesbackGood.getCreatetime());
		log.setDiscountAmount(salesbackGood.getDiscountAmount());
		log.setEndtime(salesbackGood.getEndtime());
		log.setGoodsAmount(salesbackGood.getGoodsAmount());
		log.setGoodsExpiration(salesbackGood.getGoodsExpiration());
		log.setGoodsId(salesbackGood.getGoodsId());
		log.setGoodsName(salesbackGood.getGoodsName());
		log.setGoodsPrice(salesbackGood.getGoodsPrice());
		log.setGoodsProduction(salesbackGood.getGoodsProduction());
		log.setGoodsType(salesbackGood.getGoodsType());
		log.setGoodsUnit(salesbackGood.getGoodsUnit());
		log.setLogDatetime(new Date());
		log.setModifytime(salesbackGood.getModifytime());
		log.setRemark(salesbackGood.getRemark());
		log.setSalesbackGoodsId(salesbackGood.getSalesbackGoodsId());
		log.setSalesbackSerialNumber(salesbackGood.getSalesbackSerialNumber());
		log.setStorageId(salesbackGood.getStorageId());

		return salesbackGoodsLogMapper.insert(log);
	}

}
