package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.EmployeeMapper;
import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;
import com.ai.psims.web.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Resource(name = "employeeMapper")
	private EmployeeMapper employeeMapper;

	@Override
	public List<Employee> selectByExample(EmployeeExample example) {
		return employeeMapper.selectByExample(example);
	}

	@Override
	public List<Employee> getEmployee(String username, String password) {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andEmployeeCodeLike(username);
		example.createCriteria().andLoginPasswordLike(password);
		return employeeMapper.selectByExample(example);
	}

	@Override
	public List<Employee> getlAllEmployee() {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andStatusLike("01");
		return employeeMapper.selectByExample(example);
	}

	@Override
	public Employee getUserById(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public void update(Employee employee) {
		
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public void add(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	@Override
	public void delete(Employee employee) {
		
		employeeMapper.updateByPrimaryKey(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

}
