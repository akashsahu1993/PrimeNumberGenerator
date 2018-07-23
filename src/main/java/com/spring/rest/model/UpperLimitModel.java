package com.spring.rest.model;

import org.springframework.stereotype.Component;

@Component
public class UpperLimitModel {
	
	private int upperLimit;

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	
}