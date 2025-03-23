package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.CompoundInterestCalculator;

@Service
public class CompoundInterestService {

	public double calculateCompoundInterest(CompoundInterestCalculator compoundInterestCalculator) {
        return compoundInterestCalculator.calculateCompoundInterest();
    }
}
