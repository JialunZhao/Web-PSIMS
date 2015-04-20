package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbSystemParameter;

public interface ISystemParameterService {

	List<TbSystemParameter> getlAllParameter();

	void add(TbSystemParameter sysParamete);

	TbSystemParameter getSysById(int paramId);

	void update(TbSystemParameter systemParameter);

	void delete(TbSystemParameter sysParamete);


}
