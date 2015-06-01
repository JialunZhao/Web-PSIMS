package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterLog;

public interface ISystemParameterServiceLog {

	public void addRecord(TbSystemParameter systemParameter);

	public List<TbSystemParameterLog> getSysByLogId(int paramId);

	public void updateByPid(TbSystemParameter systemParameter);
	
}
