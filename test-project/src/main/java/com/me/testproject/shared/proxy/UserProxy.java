package com.me.testproject.shared.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.me.testproject.server.entities.User;
import com.me.testproject.server.locator.EntityLocator;

@ProxyFor(value = User.class, locator = EntityLocator.class)
public interface UserProxy extends AbstractEntityProxy {

	public String getUserName();

	public void setUserName(String userName);

	public String getPassword();

	public void setPassword(String password);

	public String getAuthority();

	public void setAuthority(String authority);

	public boolean isDeleted();

	public void setDeleted(boolean deleted);

	public boolean isDisabled();

	public void setDisabled(boolean disabled);

	public AddressProxy getAddress();

	public void setAddress(AddressProxy address);

	public Long getId();
}
