package com.email.Emailsend.Dto;

import org.springframework.http.HttpStatus;

public class CustomeResponse {
	
	private String message;
	
	private HttpStatus httpStatus;
	
	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CustomeResponse() {
		super();
	}

	public CustomeResponse(String message, HttpStatus httpStatus, boolean success) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.success = success;
	}

	public CustomeResponse(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public CustomeResponse(String message) {
		super();
		this.message = message;
	}
	
	
	

}
