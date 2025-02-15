package com.example.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> serviceexception(Exception e) {
		ErrorDetails er = new ErrorDetails(e.getMessage(), "Please give correct employee id",HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorDetails>(er, HttpStatus.NOT_FOUND);

	}

}
