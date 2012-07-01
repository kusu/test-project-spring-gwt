package com.me.testproject.server.service.impl;

import java.util.List;

import com.me.testproject.server.entities.User;
import com.me.testproject.server.repositories.UserRepository;
import com.me.testproject.server.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAllUsers();
		return allUsers;
	}
}
