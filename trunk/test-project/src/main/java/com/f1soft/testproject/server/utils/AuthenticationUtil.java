package com.f1soft.testproject.server.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.f1soft.testproject.server.auth.UserDetailsWrapper;
import com.f1soft.testproject.server.entities.User;

public class AuthenticationUtil {

	public static final User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetailsWrapper) {
			return ((UserDetailsWrapper) principal).getUser();
		}
		return null;
	}
}
