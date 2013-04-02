package com.me.testproject.server.api.impl;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.me.testproject.exceptions.ClientException;
import com.me.testproject.server.api.IUserApi;
import com.me.testproject.server.auth.Authorities;
import com.me.testproject.server.entities.Address;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.repositories.AddressRepository;
import com.me.testproject.server.repositories.UserRepository;
import com.me.testproject.server.web.model.RegistrationModel;

public class UserApi implements IUserApi {

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserApi(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
		this.passwordEncoder=passwordEncoder;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAllUsers();
		return allUsers;
	}
	
	@Override
	public void registerUser(RegistrationModel model) {

		User u=new User();
		u.setUserName(model.getUsername());
		u.setPassword(passwordEncoder.encode(model.getPassword()));
		u.setDeleted(false);
		u.setDisabled(false);
		u.setCreated(new Date());
		u.setAuthority(Authorities.ROLE_USER);
		
		Address add=new Address();
		add.setCity(model.getCity());
		add.setCountry(model.getCountry());
		add.setCreated(new Date());
		
		userRepository.save(u);
	}

	@Override
	public User updateUser(User u) throws ClientException {
		User user=userRepository.findByUserName(u.getUserName());
		
		if(user==null) {
			throw new ClientException("User doesnot exists.");
		}
		
		if (u.getAddress() != null) {
			Address add=addressRepository.save(u.getAddress());
			user.setAddress(add);
		}
		user.setUserName(u.getUserName());
		user.setPassword(passwordEncoder.encode(u.getPassword()));
		user.setAuthority(u.getAuthority());
		return userRepository.save(user);
	}

	@Override
	public User createUser(User u) {
		User user=new User();
		user.setCreated(new Date());
		user.setAuthority(u.getAuthority());
		user.setUserName(u.getUserName());
		user.setPassword(passwordEncoder.encode(u.getPassword()));
		user.setAddress(u.getAddress());
		
		return userRepository.save(user);
	}

	@Override
	public User changePassword(long id, String old, String newpass) throws ClientException {
		User u=userRepository.findOne(id);
		if(u==null) {
			throw new ClientException("User doesn't exists.");
		}
		if(!passwordEncoder.matches(old, u.getPassword()) ){
			throw new ClientException("Invalid Old Password");
		}
		else {
			u.setPassword(passwordEncoder.encode(newpass));
			return userRepository.save(u);
		}
	}

	
}
