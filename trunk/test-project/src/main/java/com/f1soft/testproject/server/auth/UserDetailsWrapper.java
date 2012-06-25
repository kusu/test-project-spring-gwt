package com.f1soft.testproject.server.auth;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.f1soft.testproject.server.entities.User;



public class UserDetailsWrapper implements UserDetails, Serializable, Comparable<UserDetailsWrapper> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Collection<GrantedAuthority> authorities;
	private final User user;

	public UserDetailsWrapper(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.isDeleted();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isDisabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isDisabled();
	}

	@Override
	public boolean isEnabled() {
		return !user.isDeleted() && !user.isDisabled();
	}

	public User getUser() {
		return user;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserDetailsWrapper) {
			return ((UserDetailsWrapper) obj).getUser().getId().equals(user.getId());
		}
		return false;
	}

	@Override
	public int compareTo(UserDetailsWrapper o) {
		return 0;
	}

	@Override
	public String toString() {
		return "user" + user.getId();
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(user.getId() + "");
	}

}

