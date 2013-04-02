package com.me.testproject.server.service.impl;

import java.util.List;

import com.me.testproject.server.api.IUserApi;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.service.IUserService;

public class UserService implements IUserService {

	private final IUserApi userApi;

	public UserService(IUserApi userApi) {
		this.userApi = userApi;
	}

	@Override
	public List<User> getAllUsers() {
		return userApi.getAllUsers();
	}

	@Override
	public void updateUser(User u) {
		userApi.updateUser(u);
	}

}
