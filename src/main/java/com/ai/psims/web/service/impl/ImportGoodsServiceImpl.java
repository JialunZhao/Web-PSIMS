package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportGoodsMapper;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class ImportGoodsServiceImpl implements IImportGoodsService {
	@Resource(name = "importGoodsMapper")
	private ImportGoodsMapper importGoodsMapper;

	public int insertImportGoods(ImportGoods importGoods) {
		importGoods.setImportGoodsId(CreateIdUtil.getNewId(importGoodsMapper));
		return importGoodsMapper.insert(importGoods);
	}

}
