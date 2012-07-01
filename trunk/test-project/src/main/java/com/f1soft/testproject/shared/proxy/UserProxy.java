package com.f1soft.testproject.shared.proxy;

import com.f1soft.testproject.server.entities.User;
import com.f1soft.testproject.server.locator.EntityLocator;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

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
