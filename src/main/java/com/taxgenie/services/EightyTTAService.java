package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.EightyTTACalculator;

@Service
public class EightyTTAService {

	public double calculate80TTA(EightyTTACalculator eightyTTACalculator) {
        return eightyTTACalculator.calculate80TTA();
    }
}
