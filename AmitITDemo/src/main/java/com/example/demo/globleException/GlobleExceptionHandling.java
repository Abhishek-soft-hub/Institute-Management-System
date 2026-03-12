package com.example.demo.globleException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.CourseException;
import com.example.demo.exception.UserException;



@ControllerAdvice
public class GlobleExceptionHandling {
	@ExceptionHandler(exception = UserException.class)
	public ResponseEntity<String> userServiceException(UserException userException){
		return new ResponseEntity<>( userException.getMessage(), userException.getHttpStatus());
	}
	@ExceptionHandler(CourseException.class)
    public ResponseEntity<String> courseServiceException(CourseException courseException){
        return new ResponseEntity<>(courseException.getMessage(), courseException.getHttpStatus());
    }

}
