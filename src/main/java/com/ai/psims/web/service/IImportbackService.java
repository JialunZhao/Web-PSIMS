package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Importback;
import com.ai.psims.web.model.ImportbackExample;

public interface IImportbackService {
	public int insert(Importback importback);

	public int deleteByPrimaryKey(String importbackSerialNumber);

	public int deleteByExample(ImportbackExample example);

	public List<Importback> selectByExample(ImportbackExample example);

	public Importback selectByPrimaryKey(String importbackSerialNumber);

	public int updateByPrimaryKey(Importback record);

}
