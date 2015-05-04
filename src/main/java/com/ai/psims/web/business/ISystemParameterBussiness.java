package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;

public interface ISystemParameterBussiness {

	List<TbSystemParameter> getSystemParameterPrizePool(
			TbSystemParameterExample tbSystemParameterExample);

	TbSystemParameter getSystemParameterPrizePool(int paramId);

}
