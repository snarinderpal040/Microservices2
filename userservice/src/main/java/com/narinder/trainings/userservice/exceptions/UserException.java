package com.narinder.trainings.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserException(String message) {
		super(message);
	}

}
