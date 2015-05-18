package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IEmployeeBusiness;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.service.IEmployeeService;

@Service
public class EmployeeBusinessImpl implements IEmployeeBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeBusinessImpl.class);
	
	@Resource(name = "employeeServiceImpl")
	private IEmployeeService  employeeServiceImpl;

	@Override
	public List<TbEmployee> getEmployees(TbEmployeeExample employeeExample) {
		// 查询员工信息业务
		logger.info("tbEmployeesQuery");
		return employeeServiceImpl.selectByExample(employeeExample);
	}



}
