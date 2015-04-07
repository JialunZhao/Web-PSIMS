package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.AddSalesGoodsBean;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;

public interface ISalesBusiness {
	public List<Storagecheck> queryStrStoragechecks(
			StoragecheckExample storagecheckExample);

	public Storagecheck selectByKey(Integer storageId);

	public String addSalesList(AddSalesGoodsBean addSalesGoodsBean);

	public List<Sales> selectByExample(SalesExample example);

	public Sales selectSalesByKey(String salesSerialNumber);

	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example);
}
