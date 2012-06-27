package com.f1soft.testproject.shared.proxy;

import java.util.Date;

import com.f1soft.testproject.server.entities.AbstractEntity;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = AbstractEntity.class)
public interface AbstractEntityProxy extends EntityProxy {

	public Date getCreated();

	public Date getLastModified();

	public int getVersion();

}
