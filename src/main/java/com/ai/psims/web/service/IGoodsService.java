package com.ai.psims.web.service;

import java.util.List;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;

public interface IGoodsService {
	
	//////////////
	
	public int insertGoodsInfo(TbGoods goodsAdd);

	public int deleteGoodsInfo(TbGoods goodsDelete);

	public int modifyGoodsInfo(TbGoods goodsModify);
	
	public int backupGoodsInfo(TbGoods goodsBackup);

	public List<TbGoods> queryGoods(TbGoodsExample goodsQuery);

	public TbGoods selectGoodsInfo(Integer goodsId);
}
