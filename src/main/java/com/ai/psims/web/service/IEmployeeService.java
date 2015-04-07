package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;

public interface IEmployeeService {
	public List<Employee> selectByExample(EmployeeExample example);
}
