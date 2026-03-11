package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {
	
	private String message;
	private HttpStatus httpstatus;
	
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpstatus;
	}
	
	public UserException(String message , HttpStatus httpStatus) {
		this.message = message;
		this.httpstatus = httpStatus;
	}

}
