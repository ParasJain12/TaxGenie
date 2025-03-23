package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.SimpleInterestCalculator;

@Service
public class SimpleInterestService {

	public double calculateSimpleInterest(SimpleInterestCalculator simpleInterestCalculator) {
		return simpleInterestCalculator.calculateSimpleInterest();
	}
}
