package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;

public interface IStorehouseBusiness {
	public int storehouseAdd(TbStorehouse storehouseadd);

	public int storehouseDelete(TbStorehouse storehouseDelete);

	public int storehouseModify(TbStorehouse storehouseModify);

	public List<TbStorehouse> storehouseQuery(TbStorehouseExample storehouseQuery);
}
