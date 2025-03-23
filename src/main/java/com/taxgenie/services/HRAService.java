package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.HRACalculator;

@Service
public class HRAService {
	public double calculateHraExemption(HRACalculator hraCalculator) {
		return hraCalculator.calculateHraExemption();
	}
}
