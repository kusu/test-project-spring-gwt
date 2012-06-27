package com.f1soft.testproject.server.locator;

import com.f1soft.testproject.server.entities.Address;
import com.google.web.bindery.requestfactory.shared.Locator;

public class AddressLocator extends Locator<Address, Long> {

	@Override
	public Class<Address> getDomainType() {
		return Address.class;
	}

	@Override
	public Long getId(Address domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Address domainObject) {
		return domainObject.getVersion();
	}

	@Override
	public Address create(Class<? extends Address> clazz) {
		return new Address();
	}

	@Override
	public Address find(Class<? extends Address> clazz, Long id) {
		return new Address();
	}

}
