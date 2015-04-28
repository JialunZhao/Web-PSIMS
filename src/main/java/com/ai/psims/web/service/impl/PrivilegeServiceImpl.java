package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbPrivilegeMapper;
import com.ai.psims.web.model.TbPrivilege;
import com.ai.psims.web.model.TbPrivilegeExample;
import com.ai.psims.web.service.IPrivilegeService;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService{

	@Resource(name = "tbPrivilegeMapper")
	private TbPrivilegeMapper tbPrivilegeMapper;
	
	@Override
	public List<TbPrivilege> selectByExample(TbPrivilegeExample example) {
		return tbPrivilegeMapper.selectByExample(example);
	}

	@Override
	public TbPrivilege getPrivilege(int id) {
		return tbPrivilegeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbPrivilege privilege) {
		tbPrivilegeMapper.updateByPrimaryKey(privilege);
	}

	@Override
	public void add(TbPrivilege privilege) {
		tbPrivilegeMapper.insert(privilege);
	}

	@Override
	public void delete(TbPrivilege privilege) {
		tbPrivilegeMapper.deleteByPrimaryKey(privilege.getId());
	}

	@Override
	public List<TbPrivilege> selectByExample(TbPrivilege privilege) {
		TbPrivilegeExample example = new TbPrivilegeExample();
		 example.createCriteria().andUserIdEqualTo(privilege.getUserId());
		 return tbPrivilegeMapper.selectByExample(example);
	}
}
