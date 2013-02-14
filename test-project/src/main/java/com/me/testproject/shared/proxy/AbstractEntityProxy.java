package com.me.testproject.shared.proxy;

import java.util.Date;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.me.testproject.server.entities.AbstractEntity;

@ProxyFor(value = AbstractEntity.class)
public interface AbstractEntityProxy extends EntityProxy {

	public Date getCreated();

	public Date getLastModified();

	public int getVersion();

}
