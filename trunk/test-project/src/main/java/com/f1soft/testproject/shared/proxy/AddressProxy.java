package com.f1soft.testproject.shared.proxy;

import com.f1soft.testproject.server.entities.Address;
import com.f1soft.testproject.server.locator.AddressLocator;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(value = Address.class, locator = AddressLocator.class)
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
