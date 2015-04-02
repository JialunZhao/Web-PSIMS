package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.UpdateImportDemo;

public interface IAddGoodsImportList {
	public String addGoodsList(AddGoodsBean goodsBean);

	public List<ImportGoods> selBySerNum(String importSerialNumber);

	public String updateImportGoods(UpdateImportDemo updateImportDemo);

	public String deleteImportData(String importSerialNumber);
}
