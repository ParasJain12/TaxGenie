package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.EightyUCalculator;

@Service
public class EightyUService {

	public int calculateDeduction(EightyUCalculator dto) {
        if ("Severe".equals(dto.getDisabilityPercentage())) {
            return 125000;
        } else if ("Normal".equals(dto.getDisabilityPercentage())) {
            return 75000;
        }
        return 0;
    }
}
