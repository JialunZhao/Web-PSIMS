package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportGoodsLogMapper;
import com.ai.psims.web.dao.ImportGoodsMapper;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.ImportGoodsExample;
import com.ai.psims.web.model.ImportGoodsLog;
import com.ai.psims.web.service.IImportGoodsService;

@Service
public class ImportGoodsServiceImpl implements IImportGoodsService {
	@Resource(name = "importGoodsMapper")
	private ImportGoodsMapper importGoodsMapper;
	@Resource(name = "importGoodsLogMapper")
	private ImportGoodsLogMapper importGoodsLogMapper;

	public int updateImportGoods(ImportGoods importGoods) {
		insertToLog(importGoods);
		return importGoodsMapper.updateByPrimaryKey(importGoods);
	}

	public int updateByKey(ImportGoods importGoods) {
		insertToLog(importGoods);
		return importGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	public ImportGoods selectByPrimaryKey(Integer importGoodsId) {
		return importGoodsMapper.selectByPrimaryKey(importGoodsId);
	}

	public int deleteByPrimaryKey(Integer importGoodsId) {
		ImportGoods importGoods = new ImportGoods();
		importGoods = importGoodsMapper.selectByPrimaryKey(importGoodsId);
		insertToLog(importGoods);
		// 失效时间为当前时间
		importGoods.setImportGoodsEndtime(new Date());
		return importGoodsMapper.updateByPrimaryKeySelective(importGoods);
	}

	@Override
	public List<ImportGoods> selectByExample(ImportGoodsExample example) {
		return importGoodsMapper.selectByExample(example);
	}

	@Override
	public int insertImportGoods(ImportGoods importGoods) {
		return importGoodsMapper.insert(importGoods);
	}

	@Override
	public int insertToLog(ImportGoods importGoods) {
		ImportGoods importGood = new ImportGoods();
		importGood = importGoodsMapper.selectByPrimaryKey(importGoods
				.getImportGoodsId());
		ImportGoodsLog log = new ImportGoodsLog();

		log.setGoodsId(importGood.getGoodsId());
		log.setGoodsName(importGood.getGoodsName());
		log.setImportDiscountAmount(importGood.getImportDiscountAmount());
		log.setImportGoodsAmount(importGood.getImportGoodsAmount());
		log.setImportGoodsCreatetime(importGood.getImportGoodsCreatetime());
		log.setImportGoodsEndtime(importGood.getImportGoodsEndtime());
		log.setImportGoodsExpirationDate(importGood
				.getImportGoodsExpirationDate());
		log.setImportGoodsId(importGood.getImportGoodsId());
		log.setImportGoodsModifytime(importGood.getImportGoodsModifytime());
		log.setImportGoodsPrice(importGood.getImportGoodsPrice());
		log.setImportGoodsProductionDate(importGood
				.getImportGoodsProductionDate());
		log.setImportGoodsRemark(importGood.getImportGoodsRemark());
		log.setImportGoodsTotalPrice(importGood.getImportGoodsTotalPrice());
		log.setImportGoodsType(importGood.getImportGoodsType());
		log.setImportGoodsUnit(importGood.getImportGoodsUnit());
		log.setImportSerialNumber(importGood.getImportSerialNumber());
		log.setLogDatetime(new Date());

		return importGoodsLogMapper.insertSelective(log);
	}

}
