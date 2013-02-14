package com.me.testproject.shared.service;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.me.testproject.shared.request.UserRequestContext;

public interface TestRequestFactory extends RequestFactory {

	UserRequestContext userRequestContext();
}
