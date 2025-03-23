package com.taxgenie.model;

public class EightyCCalculator {
	private double salaryIncome;
	private double otherIncome;
	private double investment;

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double calculateTaxableIncome() {
		double grossIncome = salaryIncome + otherIncome;
		double deduction = Math.min(investment, 150000); // 80C max limit is 1.5 lakh
		return grossIncome - deduction;
	}
}
