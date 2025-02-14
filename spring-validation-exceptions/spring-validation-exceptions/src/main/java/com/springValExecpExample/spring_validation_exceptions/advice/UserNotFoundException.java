package com.springValExecpExample.spring_validation_exceptions.advice;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
	}
}
