package com.mobiquity.atmlocator.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mobiquity.atmlocator.dto.ErrorResponse;
import com.mobiquity.atmlocator.exceptions.AtmLocatorException;


/**
 * Controller Advice to handler the exceptions
 * 
 * @author Madanmohan Vasa
 */
@RestControllerAdvice
public class AtmLocatorExceptionsHandler extends ResponseEntityExceptionHandler {

	/**
	 * Exception handler to handle the AtmLocatorException
	 */
	@ExceptionHandler(AtmLocatorException.class)
	public ResponseEntity<Object> handleExceptions(RuntimeException ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
