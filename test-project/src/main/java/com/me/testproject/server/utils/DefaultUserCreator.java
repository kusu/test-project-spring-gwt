package com.me.testproject.server.utils;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.me.testproject.server.auth.Authorities;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.repositories.UserRepository;


public class DefaultUserCreator {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public DefaultUserCreator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void create() {

		if (userRepository.findByUserName("admin") == null) {
			User user = new User();
			user.setCreated(new Date());
			user.setAuthority(Authorities.ROLE_ADMIN);
			user.setUserName("admin");
			user.setPassword(passwordEncoder.encode("admin"));
			userRepository.save(user);
		}
	}
}
