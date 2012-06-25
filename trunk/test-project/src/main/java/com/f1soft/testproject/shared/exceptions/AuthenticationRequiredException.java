package com.f1soft.testproject.shared.exceptions;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuthenticationRequiredException extends ClientException implements IsSerializable {

	private static final long serialVersionUID = 1L;

	public AuthenticationRequiredException() {
	}

	public AuthenticationRequiredException(String msg) {
		super(msg);
	}

}
