package com.nelioalves.backend.services.exception;

public class DataIntegrityException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String message) {
		super(message);
	}
	
	public DataIntegrityException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
