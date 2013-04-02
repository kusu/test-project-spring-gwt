package com.me.testproject.server.service;

import java.util.List;

import com.me.testproject.exceptions.ClientException;
import com.me.testproject.server.entities.User;

public interface IUserService {

	public List<User> getAllUsers();

	void updateUser(User u) throws ClientException;

}
