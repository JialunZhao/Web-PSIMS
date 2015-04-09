package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.SystemParameter;

public interface ISystemParameterService {

	List<SystemParameter> getlAllParameter();

	void add(SystemParameter sysParamete);

}
