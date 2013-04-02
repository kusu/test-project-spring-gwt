package com.me.testproject.server.api.impl;

import java.util.List;

import com.me.testproject.server.api.IUserApi;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.repositories.AddressRepository;
import com.me.testproject.server.repositories.UserRepository;

public class UserApi implements IUserApi {

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public UserApi(UserRepository userRepository, AddressRepository addressRepository) {
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
