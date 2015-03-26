package com.ai.psims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.dao.UserMapper;
import com.ai.psims.model.User;
import com.ai.psims.service.IUserService;


@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userId);
	}

}
