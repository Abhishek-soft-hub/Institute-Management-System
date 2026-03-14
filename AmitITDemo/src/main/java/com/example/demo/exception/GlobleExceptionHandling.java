package com.example.demo.exception;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



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
	
	@ExceptionHandler(exception = BatcheException.class)
	public ResponseEntity<String> batchServiceException(BatcheException batcheException){
		return new ResponseEntity<String>(batcheException.getMessage() , batcheException.getHttpStatus());
	}

}
