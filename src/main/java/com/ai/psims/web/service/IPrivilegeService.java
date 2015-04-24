package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbPrivilege;
import com.ai.psims.web.model.TbPrivilegeExample;

public interface IPrivilegeService {
	
	public List<TbPrivilege> selectByExample(TbPrivilegeExample example);

	public TbPrivilege getPrivilege(int id);

	public void update(TbPrivilege privilege);

	public void add(TbPrivilege privilege);

	public void delete(TbPrivilege privilege);

	public List<TbPrivilege> selectByExample(TbPrivilege privilege);

}
