package com.spring.rest.ExceptionMapper;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

@Component
//@JsonComponent
public class CustomExceptionModel {
	
	private String errMessage;
	private int errCode;
	
	public CustomExceptionModel(){
		
	}
	public CustomExceptionModel(int errCode,String errMessage){
		this.errMessage=errMessage;
		this.errCode=errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	
}
