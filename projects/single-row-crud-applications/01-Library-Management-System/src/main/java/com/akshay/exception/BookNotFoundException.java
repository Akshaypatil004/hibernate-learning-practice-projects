package com.akshay.exception;
/**
 * Custom exception - use or thrown when book not found in library management
 */
public class BookNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {}
	
	public BookNotFoundException(String message) {
		super(message);
	}
	
	public BookNotFoundException(String message,Throwable e) {
		super(message,e);
	}

}
