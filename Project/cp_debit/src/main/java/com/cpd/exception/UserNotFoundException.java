package com.cpd.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
