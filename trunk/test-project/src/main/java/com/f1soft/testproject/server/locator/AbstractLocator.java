package com.f1soft.testproject.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;

public abstract class AbstractLocator<T, I> extends Locator<T, I> {

	@Override
	public T create(Class<? extends T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}

	@Override
	public T find(Class<? extends T> clazz, I id) {
		return create(clazz);
	}

}
