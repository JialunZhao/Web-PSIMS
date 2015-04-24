package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.ImportbackGoods;
import com.ai.psims.web.model.ImportbackGoodsExample;

public interface IImportbackGoodsService {
	public int insert(ImportbackGoods record);

	public List<ImportbackGoods> selectByExample(ImportbackGoodsExample example);

	public ImportbackGoods selectByPrimaryKey(Integer importbackGoodsId);

	public int updateByPrimaryKey(ImportbackGoods record);

	public int deleteByExample(ImportbackGoodsExample example);

	public int deleteByPrimaryKey(Integer importbackGoodsId);
}
