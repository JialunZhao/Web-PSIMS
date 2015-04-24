package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportbackGoodsMapper;
import com.ai.psims.web.model.ImportbackGoods;
import com.ai.psims.web.model.ImportbackGoodsExample;
import com.ai.psims.web.service.IImportbackGoodsService;

@Service
public class ImportbackGoodsServiceImpl implements IImportbackGoodsService {
	@Resource(name = "importbackGoodsMapper")
	private ImportbackGoodsMapper importbackGoodsMapper;

	@Override
	public int insert(ImportbackGoods record) {
		return importbackGoodsMapper.insertSelective(record);
	}

	@Override
	public List<ImportbackGoods> selectByExample(ImportbackGoodsExample example) {
		return importbackGoodsMapper.selectByExample(example);
	}

	@Override
	public ImportbackGoods selectByPrimaryKey(Integer importbackGoodsId) {
		return importbackGoodsMapper.selectByPrimaryKey(importbackGoodsId);
	}

	@Override
	public int updateByPrimaryKey(ImportbackGoods record) {
		return importbackGoodsMapper.insertSelective(record);
	}

	@Override
	public int deleteByExample(ImportbackGoodsExample example) {
		return importbackGoodsMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer importbackGoodsId) {
		return importbackGoodsMapper.deleteByPrimaryKey(importbackGoodsId);
	}

}
