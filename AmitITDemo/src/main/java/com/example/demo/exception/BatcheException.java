package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BatcheException extends RuntimeException{

	private String message;
	private HttpStatus httpstatus;
	
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpstatus;
	}
	
	public BatcheException(String message , HttpStatus httpStatus) {
		this.message = message;
		this.httpstatus = httpStatus;
	}
}
