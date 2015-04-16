package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;

public interface IImportGoodsService {
	public int insertImportGoods(TbImportGoods importGoods);

	public List<TbImportGoods> selectByExample(TbImportGoodsExample example);

	public int updateImportGoods(TbImportGoods importGoods);

	public int updateByKey(TbImportGoods importGoods);

	public TbImportGoods selectByPrimaryKey(Integer importGoodsId);

	public int deleteByPrimaryKey(Integer importGoodsId);

	public int insertToLog(TbImportGoods importGoods);
}
