package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.UserMapper;
import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.User;
import com.ai.psims.web.model.UserExample;
import com.ai.psims.web.service.IUserService;


@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> getUser(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andNameLike(username);
		example.createCriteria().andPwdLike(password);
		return userMapper.selectByExample(example);
	}

}
