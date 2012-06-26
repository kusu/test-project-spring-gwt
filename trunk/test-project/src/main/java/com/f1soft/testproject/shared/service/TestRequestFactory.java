package com.f1soft.testproject.shared.service;

import com.f1soft.testproject.shared.request.UserRequest;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface TestRequestFactory extends RequestFactory {

	UserRequest userRequest();
}
