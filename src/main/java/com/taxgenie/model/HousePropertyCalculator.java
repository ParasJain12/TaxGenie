package com.taxgenie.model;

public class HousePropertyCalculator {

	private double annualRent;
	private double municipalTaxes;
	private double standardDeduction = 30;
	private double interestOnLoan;

	public double getAnnualRent() {
		return annualRent;
	}

	public void setAnnualRent(double annualRent) {
		this.annualRent = annualRent;
	}

	public double getMunicipalTaxes() {
		return municipalTaxes;
	}

	public void setMunicipalTaxes(double municipalTaxes) {
		this.municipalTaxes = municipalTaxes;
	}

	public double getStandardDeduction() {
		return standardDeduction;
	}

	public void setStandardDeduction(double standardDeduction) {
		this.standardDeduction = standardDeduction;
	}

	public double getInterestOnLoan() {
		return interestOnLoan;
	}

	public void setInterestOnLoan(double interestOnLoan) {
		this.interestOnLoan = interestOnLoan;
	}

	public double calculateNetAnnualValue() {
		return annualRent - municipalTaxes;
	}

	public double calculateHousePropertyIncome() {
		double netAnnualValue = calculateNetAnnualValue();
		double incomeFromHouseProperty = netAnnualValue - (netAnnualValue * standardDeduction / 100) - interestOnLoan;
		return incomeFromHouseProperty;
	}
}
