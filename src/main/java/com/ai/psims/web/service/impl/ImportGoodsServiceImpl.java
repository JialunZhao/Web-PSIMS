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
	private TbImportGoodsMapper importGoodsMapper;
	@Resource(name = "tbImportGoodsLogMapper")
	private TbImportGoodsLogMapper importGoodsLogMapper;

	public int updateImportGoods(TbImportGoods importGoods) {
		insertToLog(importGoods);
		return importGoodsMapper.updateByPrimaryKey(importGoods);
	}

	public int updateByKey(TbImportGoods importGoods) {
		insertToLog(importGoods);
		return importGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	public TbImportGoods selectByPrimaryKey(Integer importGoodsId) {
		return importGoodsMapper.selectByPrimaryKey(importGoodsId);
	}

	public int deleteByPrimaryKey(Integer importGoodsId) {
		TbImportGoods importGoods = new TbImportGoods();
		importGoods = importGoodsMapper.selectByPrimaryKey(importGoodsId);
		insertToLog(importGoods);
		// 失效时间为当前时间
		importGoods.setImportGoodsEndtime(new Date());
		return importGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	@Override
	public List<TbImportGoods> selectByExample(TbImportGoodsExample example) {
		return importGoodsMapper.selectByExample(example);
	}

	@Override
	public int insertImportGoods(TbImportGoods importGoods) {
		return importGoodsMapper.insert(importGoods);
	}

	@Override
	public int insertToLog(TbImportGoods importGoods) {
		TbImportGoods importGood = new TbImportGoods();
		importGood = importGoodsMapper.selectByPrimaryKey(importGoods
				.getImportGoodsId());
		TbImportGoodsLog log = new TbImportGoodsLog();

		log.setGoodsId(importGood.getGoodsId());
		log.setGoodsName(importGood.getGoodsName());
		log.setImportDiscountAmount(importGood.getImportDiscountAmount());
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
		log.setDiscountTotalPrice(importGood.getDiscountTotalPrice());
		log.setDiscountRate(importGood.getDiscountRate());
		log.setIsDiscount(importGood.getIsDiscount());
		log.setTotalPrice(importGood.getTotalPrice());
		log.setIsBoxBottle(importGood.getIsBoxBottle());
		log.setBoxBottlePrice(importGood.getBoxBottlePrice());
		log.setResImportGoodsAmount(importGood.getResImportGoodsAmount());

		return importGoodsLogMapper.insertSelective(log);
	}

}
