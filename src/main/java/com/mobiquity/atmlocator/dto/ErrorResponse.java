package com.mobiquity.atmlocator.dto;

/**
 * Class that wraps the error details (in case of error scenarios) and will be returned to client in the ResonseEntiry
 * 
 * @author Madanmohan Vasa
 */

public class ErrorResponse {
	
	public ErrorResponse(String reason, String statusCode) {
		super();
		this.reason = reason;
		this.statusCode = statusCode;
	}
	private String reason;
	private String statusCode;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
