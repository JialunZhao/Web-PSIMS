package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;

public interface ISystemParameterService {

	List<TbSystemParameter> getlAllParameter();

	void add(TbSystemParameter sysParamete);

	TbSystemParameter getSysById(int paramId);

	void update(TbSystemParameter systemParameter);

	void delete(TbSystemParameter sysParamete);

	public List<TbSystemParameter> getSystemParameterPrizePool(
			TbSystemParameterExample tbSystemParameterExample);

	public TbSystemParameter getSystemParameterPrizePool(int paramId);

	List<TbSystemParameter> selectByExample(
			TbSystemParameterExample tbSystemParameterExample);

}
