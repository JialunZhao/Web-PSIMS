package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.AddSalesGoodsBean;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.SalesUpdateData;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

public interface ISalesBusiness {
	public List<TbStoragecheck> queryStrTbStoragechecks(
			TbStoragecheckExample storagecheckExample);

	public TbStoragecheck queryTbStoragecheck(
			TbStoragecheckExample storagecheckExample,int goodsName);

	public TbStoragecheck selectByKey(Integer storageId);

	public String addSalesList(AddSalesGoodsBean addSalesGoodsBean,String remark);

	public List<Sales> selectByExample(SalesExample example);

	public Sales selectSalesByKey(String salesSerialNumber);

	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example);

	public String updateSalesData(SalesUpdateData salesUpdateData, Sales sales);

	public String deleteSalesData(String salesSerialNumber);
}
