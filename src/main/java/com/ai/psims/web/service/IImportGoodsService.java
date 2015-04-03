package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.ImportGoods;

public interface IImportGoodsService {
	public int insertImportGoods(ImportGoods importGoods);

	public List<ImportGoods> selBySerNum(String importSerialNumber);

	public int updateImportGoods(ImportGoods importGoods);

	public ImportGoods selectByPrimaryKey(Integer importGoodsId);
	
	public int deleteByPrimaryKey(Integer importGoodsId);
}
