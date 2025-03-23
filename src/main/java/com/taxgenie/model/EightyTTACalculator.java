package com.taxgenie.model;

public class EightyTTACalculator {

	private double interestIncome;

	public double getInterestIncome() {
		return interestIncome;
	}

	public void setInterestIncome(double interestIncome) {
		this.interestIncome = interestIncome;
	}
	
	public double calculate80TTA() {
        double deductionLimit = 10000;
        return Math.min(interestIncome, deductionLimit);
    }
}
