package com.ai.psims.web.service;

import java.util.List;



import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;

public interface IEmployeeService {
	public List<TbEmployee> selectByExample(TbEmployeeExample example);

	public List<TbEmployee> getEmployee(String username, String password);
	
	public List<TbEmployee> getEmployee(String username);
	
	public TbEmployee getEmployee(int id);

	public List<TbEmployee> getlAllEmployee();

	public TbEmployee getUserById(int employeeId);

	public void update(TbEmployee employee);

	public void add(TbEmployee employee);

	public void delete(TbEmployee employee);

	public List<TbEmployee> getEmployee(String employeeName, String sex,
			String role, String contactTel);
	

	public List<TbEmployee> selectByExample1(TbEmployeeExample employeeExample);

	TbEmployee selectByPrimaryKey(Integer employeeId);

	
}
