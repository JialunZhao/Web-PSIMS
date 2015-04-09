package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;

public interface IEmployeeService {
	public List<Employee> selectByExample(EmployeeExample example);

	public List<Employee> getEmployee(String username, String password);
	
	public Employee getEmployee(int id);

	public List<Employee> getlAllEmployee();

	public Employee getUserById(int employeeId);

	public void update(Employee employee);

	public void add(Employee employee);

	public void delete(Employee employee);
}
