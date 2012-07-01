package com.me.testproject.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.me.testproject.server.entities.AbstractEntity;

public class EntityLocator extends Locator<AbstractEntity<Long>, Long> {

	@Override
	public AbstractEntity<Long> create(Class<? extends AbstractEntity<Long>> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public AbstractEntity<Long> find(Class<? extends AbstractEntity<Long>> clazz, Long id) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Class<AbstractEntity<Long>> getDomainType() {
		return null;
	}

	@Override
	public Long getId(AbstractEntity<Long> domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(AbstractEntity<Long> domainObject) {
		return domainObject.getVersion();
	}

}
