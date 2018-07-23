package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.ExceptionMapper.InvalidRequest;
import com.spring.rest.model.UpperLimitModel;

@Component
public class PrimeNumberService {

	@Autowired
	UpperLimitModel upperLimitModel;

	public void setUpLimit(int upperLimit) {
		upperLimitModel.setUpperLimit(upperLimit);
	}

	public int getUpLimit() {
		return upperLimitModel.getUpperLimit();
	}

	public List<Integer> getPrimeNumberList(int upLimit) throws InvalidRequest{
		List<Integer> primeNumberList = new ArrayList<>();
		try {
			primeNumberList.add(2);
			int status = 0;
			for (int i = 2; i <= upLimit; i++) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						status = 0;
						break;
					}
				}
				if (status != 0) {
					primeNumberList.add(i);
				}
				status = 1;
			}
		} catch (Exception e) {
			throw new InvalidRequest(909,"Exception While Calculating Prime Numbers. Please provide valid input.");
		}
		return primeNumberList;
	}
}
