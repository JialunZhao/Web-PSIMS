package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

public interface IStorageCheckBusiness {
	public List<TbStoragecheck> selectStoragecheck(
			TbStoragecheckExample tbStoragecheckExample);

}
