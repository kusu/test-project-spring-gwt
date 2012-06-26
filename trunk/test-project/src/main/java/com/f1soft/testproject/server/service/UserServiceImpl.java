package com.f1soft.testproject.server.service;

import java.util.List;

import com.f1soft.testproject.server.entities.User;
import com.f1soft.testproject.server.repositories.UserRepository;
import com.f1soft.testproject.shared.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAllUsers();
	}
}
