package com.taxgenie.model;

import java.time.LocalDate;

public class SSYCalculator {

	private double totalInvestment;
	private double totalInterest;
	private double maturityAmount;
	private LocalDate maturityDate;

	public double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	/*public SSYCalculator(double totalInvestment, double totalInterest, double maturityAmount, LocalDate maturityDate) {
		super();
		this.totalInvestment = totalInvestment;
		this.totalInterest = totalInterest;
		this.maturityAmount = maturityAmount;
		this.maturityDate = maturityDate;
	}*/

}
