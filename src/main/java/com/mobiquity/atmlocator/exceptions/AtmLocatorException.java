package com.mobiquity.atmlocator.exceptions;
/**
 * Custom Exception class that provides exception information
 * 
 * @author Madanmohan Vasa
 */
public class AtmLocatorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AtmLocatorException(String message){
		super(message);
	}
}
