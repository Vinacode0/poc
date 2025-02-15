package com.example.poc.exception;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private String message;
    private String details;
    private HttpStatus errorcode;

    public ErrorDetails(String message, String details,HttpStatus errorcode) {
        super();
        this.message = message;
        this.details = details;
        this.errorcode = errorcode;
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

	public HttpStatus getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(HttpStatus errorcode) {
		this.errorcode = errorcode;
	}

	

   
}
