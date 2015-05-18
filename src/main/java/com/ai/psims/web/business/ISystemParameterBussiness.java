package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;

public interface ISystemParameterBussiness {

	List<TbSystemParameter> selectByExample(
			TbSystemParameterExample tbSystemParameterExample);
	
	List<TbSystemParameter> getSystemParameterPrizePool(
			TbSystemParameterExample tbSystemParameterExample);

	TbSystemParameter getSystemParameterPrizePool(int paramId);

	void add(TbSystemParameter sysParamete);

	TbSystemParameter getSysById(int paramId);

	void update(TbSystemParameter systemParameter);

	void addRecord(TbSystemParameter systemParameter);

	void delete(TbSystemParameter sysParamete);

	List<TbSystemParameter> getlAllParameter();

}
