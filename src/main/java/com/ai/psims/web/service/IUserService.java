package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.User;

public interface IUserService {
	public User getUserById(int userId);

	public List<User> getUser(String username, String password);
}