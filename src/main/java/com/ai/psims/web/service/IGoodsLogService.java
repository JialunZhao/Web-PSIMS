package com.ai.psims.web.service;

import com.ai.psims.web.model.GoodsLog;

public interface IGoodsLogService {
	public GoodsLog queryGoodsLogByKey(Integer id);
	
	public int deleteGoodsLogByKey(Integer id);
	
	public int updateGoodsLogByKey(GoodsLog goodsLog);
	
	public int insertGoodsLog(GoodsLog goodsLog);
}
