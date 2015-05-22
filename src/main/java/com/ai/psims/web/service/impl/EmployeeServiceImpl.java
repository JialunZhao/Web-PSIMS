package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbEmployeeMapper;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Resource(name = "tbEmployeeMapper")
	private TbEmployeeMapper tbEmployeeMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public List<TbEmployee> selectByExample(TbEmployeeExample example) {
		return tbEmployeeMapper.selectByExample(example);
	}

	@Override
	public List<TbEmployee> getEmployee(String username, String password) {
		TbEmployeeExample example = new TbEmployeeExample();
		example.createCriteria().andEmployeeCodeEqualTo(username).andLoginPasswordEqualTo(password);
		return tbEmployeeMapper.selectByExample(example);
	}
	
	@Override
	public List<TbEmployee> getEmployee(String username) {
		TbEmployeeExample example = new TbEmployeeExample();
		example.createCriteria().andEmployeeCodeEqualTo(username);
		return tbEmployeeMapper.selectByExample(example);
	}

	@Override
	public List<TbEmployee> getlAllEmployee() {
		TbEmployeeExample example = new TbEmployeeExample();
		example.createCriteria().andStatusLike("01");
		return tbEmployeeMapper.selectByExample(example);
	}

	@Override
	public TbEmployee getUserById(int employeeId) {
		return tbEmployeeMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public void update(TbEmployee employee) {
		
		tbEmployeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public void add(TbEmployee employee) {
		tbEmployeeMapper.insertSelective(employee);
	}

	@Override
	public void delete(TbEmployee employee) {
		
		tbEmployeeMapper.updateByPrimaryKey(employee);
	}

	@Override
	public TbEmployee getEmployee(int id) {
		return tbEmployeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TbEmployee> getEmployee(String employeeName, String sex,
			String role, String contactTel) {
		TbEmployeeExample example = new TbEmployeeExample();
		if(employeeName!=null && employeeName.length()>0){
			example.createCriteria().andEmployeeNameLike(employeeName);
		}
		if(sex!=null && sex.length()>0){
			example.createCriteria().andSexLike(sex);
		}
		if(role!=null && role.length()>0){
			example.createCriteria().andRoleLike(role);
		}
		if(contactTel!=null && contactTel.length()>0){
			example.createCriteria().andContactTelLike(contactTel);
		}
		return tbEmployeeMapper.selectByExample(example);
	}

	@Override
	public List<TbEmployee> selectByExample1(TbEmployeeExample employeeExample) {
		logger.info("tbEmployeeMapper.selectByExample(employeeExample);");
		return tbEmployeeMapper.selectByExample(employeeExample);
	}

	@Override
	public TbEmployee selectByPrimaryKey(Integer employeeId) {
		logger.info("tbEmployeeMapper.selectByPrimaryKey(employeeId);");
		return tbEmployeeMapper.selectByPrimaryKey(employeeId);
	}

}
