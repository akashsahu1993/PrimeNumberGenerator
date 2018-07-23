package com.spring.rest.model;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {

	private int successCode;
	private String successMessage;
	public int getSuccessCode() {
		return successCode;
	}
	public void setSuccessCode(int successCode) {
		this.successCode = successCode;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public SuccessResponse(int successCode, String successMessage) {
		super();
		this.successCode = successCode;
		this.successMessage = successMessage;
	}
	public SuccessResponse() {
		
	}
	
}
