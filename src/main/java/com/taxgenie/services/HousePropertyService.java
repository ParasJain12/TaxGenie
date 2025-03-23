package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.HousePropertyCalculator;

@Service
public class HousePropertyService {

	public double calculateHousePropertyIncome(HousePropertyCalculator housePropertyCalculator) {
        return housePropertyCalculator.calculateHousePropertyIncome();
    }
}
