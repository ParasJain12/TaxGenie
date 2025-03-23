package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.EightyDDCalculator;

@Service
public class EightyDDService {
	public double calculateDeduction(EightyDDCalculator eightyDDCalculator) {
        return eightyDDCalculator.calculateDeduction();
    }
}
