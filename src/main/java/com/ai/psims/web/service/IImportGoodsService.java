package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.ImportGoodsExample;

public interface IImportGoodsService {
	public int insertImportGoods(ImportGoods importGoods);

	public List<ImportGoods> selectByExample(ImportGoodsExample example);

	public int updateImportGoods(ImportGoods importGoods);

	public int updateByKey(ImportGoods importGoods);

	public ImportGoods selectByPrimaryKey(Integer importGoodsId);

	public int deleteByPrimaryKey(Integer importGoodsId);

	public int insertToLog(ImportGoods importGoods);
}
