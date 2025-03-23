package com.taxgenie.model;

public class HRACalculator {
	private double basicSalary;
	private double hraRecieved;
	private double rentPaid;
	private String cityType;

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHraRecieved() {
		return hraRecieved;
	}

	public void setHraRecieved(double hraRecieved) {
		this.hraRecieved = hraRecieved;
	}

	public double getRentPaid() {
		return rentPaid;
	}

	public void setRentPaid(double rentPaid) {
		this.rentPaid = rentPaid;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public double calculateHraExemption() {
		double hraExemption = 0;

		double rentMinusTenPercentSalary = rentPaid - (0.1 * basicSalary);
		double fiftyPercentSalary = 0.5 * basicSalary;
		if ("metro".equals(cityType.toLowerCase())) {
			fiftyPercentSalary = 0.5 * basicSalary;
		} else {
			fiftyPercentSalary = 0.4 * basicSalary;
		}

		hraExemption = Math.min(hraRecieved, Math.min(rentMinusTenPercentSalary, fiftyPercentSalary));
		return Math.max(hraExemption, 0);
	}

}
