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
	private TbSystemParameterMapper systemParameterMapper;
	
	@Override
	public List<TbSystemParameter> getlAllParameter() {
		TbSystemParameterExample example = new TbSystemParameterExample();
		example.createCriteria().andPStatusLike("01");
		return systemParameterMapper.selectByExample(example);
	}

	@Override
	public void add(TbSystemParameter sysParamete) {
		systemParameterMapper.insertSelective(sysParamete);
	}

	@Override
	public TbSystemParameter getSysById(int paramId) {
		return systemParameterMapper.selectByPrimaryKey(paramId);
	}

	@Override
	public void update(TbSystemParameter systemParameter) {
		systemParameterMapper.updateByPrimaryKeySelective(systemParameter);
		
	}

	@Override
	public void delete(TbSystemParameter sysParamete) {
		systemParameterMapper.updateByPrimaryKeySelective(sysParamete);
		
	}

	
}
