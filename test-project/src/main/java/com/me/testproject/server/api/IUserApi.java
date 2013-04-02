package com.me.testproject.server.api;

import java.util.List;

import com.me.testproject.exceptions.ClientException;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.web.model.RegistrationModel;

public interface IUserApi {

	public List<User> getAllUsers();

	User updateUser(User u);
	
	User createUser(User u);
	
	User changePassword(long id,String old, String newpass) throws ClientException;

	void registerUser(RegistrationModel model);
}
