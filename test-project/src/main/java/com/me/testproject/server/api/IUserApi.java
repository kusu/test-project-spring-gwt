package com.me.testproject.server.api;

import java.util.List;

import com.me.testproject.server.entities.User;

public interface IUserApi {

	public List<User> getAllUsers();

	void updateUser(User u);
}
