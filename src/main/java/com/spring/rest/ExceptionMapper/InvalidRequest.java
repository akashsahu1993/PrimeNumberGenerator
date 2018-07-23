package com.spring.rest.ExceptionMapper;

import org.springframework.stereotype.Component;

public class InvalidRequest extends Exception{

	private int errorCode;
	
	public InvalidRequest(int errorCode,String errorMessage){
		super(errorMessage);
		this.errorCode=errorCode;
	}

	public int getInvalidRequestErrorCode() {
		return errorCode;
	}

	public void setInvalidRequestErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
