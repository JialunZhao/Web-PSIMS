package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.UpdateImportDemo;

public interface IAddGoodsImportList {
	public String addGoodsList(AddGoodsBean goodsBean);

	public List<TbImportGoods> selBySerNum(String importSerialNumber);

	public String updateImportGoods(UpdateImportDemo updateImportDemo);

	public String deleteImportData(String importSerialNumber);

	public List<String> getGoodsName(String importSerialNumber);

	public List<TbImportGoods> queryImportGoods(TbImportGoodsExample example);

	public String goodsImport(String goodList, String importSerialNumber,
			String storeName, String storeId);
};
