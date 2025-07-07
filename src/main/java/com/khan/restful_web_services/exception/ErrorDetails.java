package com.khan.restful_web_services.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDetails {
	private LocalDateTime localDateTime;
	private String message;
	private String details;
	private List<String> errors;
	
	public ErrorDetails() {
		
	}
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;	
	}
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details, List<String> errors) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
		this.errors = errors;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorDetails [localDateTime=" + localDateTime + ", message=" + message + ", details=" + details
				+ ", errors=" + errors + "]";
	}	
}
