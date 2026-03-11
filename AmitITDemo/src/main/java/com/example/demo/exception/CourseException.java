package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CourseException extends RuntimeException {
	
	private String message;
	private HttpStatus httpstatus;
	
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpstatus;
	}
	
	public CourseException(String message , HttpStatus httpStatus) {
		this.message = message;
		this.httpstatus = httpStatus;
	}


}
