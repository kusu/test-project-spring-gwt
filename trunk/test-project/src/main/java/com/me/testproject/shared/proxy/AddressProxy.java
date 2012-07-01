package com.me.testproject.shared.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.me.testproject.server.entities.Address;
import com.me.testproject.server.locator.EntityLocator;

@ProxyFor(value = Address.class, locator = EntityLocator.class)
public interface AddressProxy extends ValueProxy {

	public String getFirstLine();

	public void setFirstLine(String firstLine);

	public String getStreet();

	public void setStreet(String street);

	public String getCity();

	public void setCity(String city);

	public String getState();

	public void setState(String state);

	public String getCountry();

	public void setCountry(String country);

	public Long getId();
}
