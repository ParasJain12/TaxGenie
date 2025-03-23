package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.EightyCCalculator;

@Service
public class EightyCService {
	public double calculateTaxableIncome(EightyCCalculator eightyCCalculator) {
		return eightyCCalculator.calculateTaxableIncome();
	}
	
	
}
