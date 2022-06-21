package com.spring.marble.excrption;

public class LoginException extends RuntimeException {
	public LoginException(String message) {
		super(message);
	}
}
