package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionController {
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<String> handleException(Exception ex){
		if(ex instanceof UserNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity("Invalid User Id ", status);
		}
		else {
			return null;
		}
	}

}
