package com.f1soft.testproject.shared.exceptions;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ClientException extends Exception implements IsSerializable {

	private static final long serialVersionUID = 1L;
	private String message;

	public ClientException() {

	}

	public ClientException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
