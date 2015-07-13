package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbImportGoodsLogMapper;
import com.ai.psims.web.dao.TbImportGoodsMapper;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbImportGoodsLog;
import com.ai.psims.web.service.IImportGoodsService;

@Service
public class ImportGoodsServiceImpl implements IImportGoodsService {
	@Resource(name = "tbImportGoodsMapper")
	private TbImportGoodsMapper tbImportGoodsMapper;
	@Resource(name = "tbImportGoodsLogMapper")
	private TbImportGoodsLogMapper tbImportGoodsLogMapper;

	public int updateImportGoods(TbImportGoods importGoods) {
		insertToLog(importGoods);
		return tbImportGoodsMapper.updateByPrimaryKey(importGoods);
	}

	public int updateByKey(TbImportGoods importGoods) {
		insertToLog(importGoods);
		return tbImportGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	public TbImportGoods selectByPrimaryKey(Integer importGoodsId) {
		return tbImportGoodsMapper.selectByPrimaryKey(importGoodsId);
	}

	public int deleteByPrimaryKey(Integer importGoodsId) {
		TbImportGoods importGoods = new TbImportGoods();
		importGoods = tbImportGoodsMapper.selectByPrimaryKey(importGoodsId);
		insertToLog(importGoods);
		// 失效时间为当前时间
		importGoods.setImportGoodsEndtime(new Date());
		return tbImportGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	@Override
	public List<TbImportGoods> selectByExample(TbImportGoodsExample example) {
		return tbImportGoodsMapper.selectByExample(example);
	}

	@Override
	public int insertImportGoods(TbImportGoods importGoods) {
		return tbImportGoodsMapper.insert(importGoods);
	}

	@Override
	public int insertToLog(TbImportGoods importGoods) {
		TbImportGoods importGood = new TbImportGoods();
		importGood = tbImportGoodsMapper.selectByPrimaryKey(importGoods
				.getImportGoodsId());
		TbImportGoodsLog log = new TbImportGoodsLog();

		log.setGoodsId(importGood.getGoodsId());
		log.setGoodsName(importGood.getGoodsName());
		log.setImportDiscountPrice(importGood.getImportDiscountPrice());
		log.setImportGoodsAmount(importGood.getImportGoodsAmount());
		log.setImportGoodsCreatetime(importGood.getImportGoodsCreatetime());
		log.setImportGoodsEndtime(importGood.getImportGoodsEndtime());
		log.setImportGoodsId(importGood.getImportGoodsId());
		log.setImportGoodsModifytime(importGood.getImportGoodsModifytime());
		log.setImportGoodsPrice(importGood.getImportGoodsPrice());
		log.setImportGoodsRemark(importGood.getImportGoodsRemark());
		log.setImportGoodsType(importGood.getImportGoodsType());
		log.setImportGoodsUnit(importGood.getImportGoodsUnit());
		log.setImportSerialNumber(importGood.getImportSerialNumber());
		log.setLogDatetime(new Date());
		log.setDiscountDutyTotalPrice(importGood.getDiscountDutyTotalPrice());
		log.setDiscountGoodsTotalPrice(importGood.getDiscountGoodsTotalPrice());
		log.setImportDiscountRate(importGood.getImportDiscountRate());
		log.setIsDiscount(importGood.getIsDiscount());
		log.setImportTotalPrice(importGood.getImportTotalPrice());
		log.setIsBoxBottle(importGood.getIsBoxBottle());
		log.setBoxBottlePrice(importGood.getBoxBottlePrice());
		log.setResImportGoodsAmount(importGood.getResImportGoodsAmount());

		return tbImportGoodsLogMapper.insertSelective(log);
	}

}
