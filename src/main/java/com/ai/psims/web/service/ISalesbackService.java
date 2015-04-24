package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;

public interface ISalesbackService {
	int deleteByExample(SalesbackExample example);

	int deleteByPrimaryKey(String salesbackSerialNumber);

	int insert(Salesback record);

	int insertByKey(Salesback record);

	List<Salesback> selectByExample(SalesbackExample example);

	Salesback selectByPrimaryKey(String salesbackSerialNumber);

	int updateByPrimaryKey(Salesback record);

	int update(Salesback record);

	int insertToLog(Salesback salesback);

	String getSalesbackSerialNumber(String salesbackSerialNumber);
}
