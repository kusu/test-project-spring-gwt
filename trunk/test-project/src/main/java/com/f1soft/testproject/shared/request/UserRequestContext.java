package com.f1soft.testproject.shared.request;

import java.util.List;

import com.f1soft.testproject.server.locator.TestServiceLocator;
import com.f1soft.testproject.server.service.impl.UserServiceImpl;
import com.f1soft.testproject.shared.proxy.UserProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = UserServiceImpl.class, locator = TestServiceLocator.class)
public interface UserRequestContext extends RequestContext {

	public Request<List<UserProxy>> getAllUsers();

}
