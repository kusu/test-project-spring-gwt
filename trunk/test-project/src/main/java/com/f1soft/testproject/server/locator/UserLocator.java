package com.f1soft.testproject.server.locator;

import com.f1soft.testproject.server.entities.User;
import com.google.web.bindery.requestfactory.shared.Locator;

public class UserLocator extends Locator<User, Long> {

	@Override
	public User create(Class<? extends User> clazz) {
		return new User();
	}

	@Override
	public User find(Class<? extends User> clazz, Long id) {
		return new User();
	}

	@Override
	public Class<User> getDomainType() {
		return User.class;
	}

	@Override
	public Long getId(User domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(User domainObject) {
		return domainObject.getVersion();
	}

}
