package com.taxgenie.model;

public class CompoundInterestCalculator {
	private double principal;
	private double rate;
	private double time;
	private int timesCompounded;

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

	public int getTimesCompounded() {
		return timesCompounded;
	}

	public void setTimesCompounded(int timesCompounded) {
		this.timesCompounded = timesCompounded;
	}
	
	public double calculateCompoundInterest() {
        return principal * Math.pow((1 + (rate / (100 * timesCompounded))), (timesCompounded * time));
    }

}
