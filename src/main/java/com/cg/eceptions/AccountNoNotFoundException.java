package com.cg.eceptions;

public class AccountNoNotFoundException extends RuntimeException{

	public AccountNoNotFoundException(String message) {
		super(message);

	}

	public AccountNoNotFoundException(String message, Throwable t) {
		super(message,t);
	
	}

	
}
