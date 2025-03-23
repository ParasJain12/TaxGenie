package com.taxgenie.model;

public class NSCCalculator {

	private String nscType;
	private String period;
	private double investmentAmount;

	public String getNscType() {
		return nscType;
	}

	public void setNscType(String nscType) {
		this.nscType = nscType;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

}
