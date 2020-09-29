package com.cg.eceptions;

public class AadharNotFoundException extends RuntimeException{

	public AadharNotFoundException(String message, Throwable t) {
		super(message, t);

	}

	public AadharNotFoundException(String message) {
		super(message);
	
	}
	

}
