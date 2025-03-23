package com.taxgenie.model;

public class SimpleInterestCalculator {
	private double principal;
	private double rate;
	private double time;

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double calculateSimpleInterest() {
        return (principal * rate * time) / 100;
    }
}
