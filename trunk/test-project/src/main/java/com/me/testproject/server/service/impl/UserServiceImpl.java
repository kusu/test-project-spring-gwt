package com.me.testproject.server.service.impl;

import java.util.List;

import com.me.testproject.server.entities.User;
import com.me.testproject.server.repositories.AddressRepository;
import com.me.testproject.server.repositories.UserRepository;
import com.me.testproject.server.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAllUsers();
		return allUsers;
	}

	@Override
	public void updateUser(User u) {
		if (u.getAddress() != null) {
			addressRepository.save(u.getAddress());
		}
		userRepository.save(u);
	}

}
