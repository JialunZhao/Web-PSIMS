package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbSystemParameterMapper;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
import com.ai.psims.web.service.ISystemParameterService;

@Service
public class SystemParameterServiceImpl implements ISystemParameterService {

	@Resource
	private TbSystemParameterMapper tbSystemParameterMapper;

	@Override
	public List<TbSystemParameter> getlAllParameter() {
		TbSystemParameterExample example = new TbSystemParameterExample();
		example.createCriteria().andPStatusLike("01");
		return tbSystemParameterMapper.selectByExample(example);
	}

	@Override
	public void add(TbSystemParameter sysParamete) {
		tbSystemParameterMapper.insertSelective(sysParamete);
	}

	@Override
	public TbSystemParameter getSysById(int paramId) {
		return tbSystemParameterMapper.selectByPrimaryKey(paramId);
	}

	@Override
	public void update(TbSystemParameter systemParameter) {
		tbSystemParameterMapper.updateByPrimaryKeySelective(systemParameter);

	}

	@Override
	public void delete(TbSystemParameter sysParamete) {
		tbSystemParameterMapper.updateByPrimaryKeySelective(sysParamete);

	}

	//获取奖金池金额
	@Override
	public List<TbSystemParameter> getSystemParameterPrizePool(
			TbSystemParameterExample tbSystemParameterExample) {
		return tbSystemParameterMapper.selectByExample(tbSystemParameterExample);
	}
	public TbSystemParameter getSystemParameterPrizePool(int paramId) {
		return tbSystemParameterMapper.selectByPrimaryKey(paramId);
	}

	@Override
	public List<TbSystemParameter> selectByExample(
			TbSystemParameterExample tbSystemParameterExample) {
		return tbSystemParameterMapper.selectByExample(tbSystemParameterExample);
	}
	
}
