package com.spring.rest.ExceptionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	CustomExceptionModel customException;
	@ExceptionHandler(InvalidRequest.class)
	public final ResponseEntity userNotFoundException(InvalidRequest ex) {
		System.out.println("in Exception handler");
		customException.setErrCode(ex.getInvalidRequestErrorCode()); 
		customException.setErrMessage(ex.getMessage()); 
	    return new ResponseEntity<CustomExceptionModel>(customException, HttpStatus.BAD_REQUEST);
		//return customException;
	  }
}
