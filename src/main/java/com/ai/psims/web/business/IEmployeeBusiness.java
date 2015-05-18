package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;

public interface IEmployeeBusiness {

	public List<TbEmployee> getEmployees(TbEmployeeExample employeeExample);
}
