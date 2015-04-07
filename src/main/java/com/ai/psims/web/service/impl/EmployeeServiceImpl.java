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

}
