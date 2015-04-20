package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;

public interface IGoodsBusiness {
	public int goodsAdd(TbGoods goodsadd);

	public int goodsDelete(TbGoods goodsDelete);

	public int goodsModify(TbGoods goodsModify);

	public List<TbGoods> goodsQuery(TbGoodsExample goodsQuery);	
	
}
