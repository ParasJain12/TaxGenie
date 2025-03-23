package com.taxgenie.model;

public class TransportAllowanceCalculator {

	private int yearlyTransportAllowance;
	private boolean isHandicapped;

	public int getYearlyTransportAllowance() {
		return yearlyTransportAllowance;
	}

	public void setYearlyTransportAllowance(int yearlyTransportAllowance) {
		this.yearlyTransportAllowance = yearlyTransportAllowance;
	}

	public boolean isHandicapped() {
		return isHandicapped;
	}

	public void setHandicapped(boolean isHandicapped) {
		this.isHandicapped = isHandicapped;
	}

}
