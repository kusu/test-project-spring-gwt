package com.me.testproject.shared.request;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.me.testproject.server.locator.TestServiceLocator;
import com.me.testproject.server.service.impl.UserServiceImpl;
import com.me.testproject.shared.proxy.UserProxy;

@Service(value = UserServiceImpl.class, locator = TestServiceLocator.class)
public interface UserRequestContext extends RequestContext {

	public Request<List<UserProxy>> getAllUsers();

	public Request<Void> updateUser(UserProxy proxy);
}
