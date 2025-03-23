package com.taxgenie.model;

public class EightyDDCalculator {
	private double dependentMedicalExpenses;
	private double maximumDeduction = 75000; // Regular deduction limit
	private double severeDisabilityDeduction = 125000; // Severe disability deduction limit
	private boolean severeDisability;

	public double getDependentMedicalExpenses() {
		return dependentMedicalExpenses;
	}

	public void setDependentMedicalExpenses(double dependentMedicalExpenses) {
		this.dependentMedicalExpenses = dependentMedicalExpenses;
	}

	public boolean isSevereDisability() {
		return severeDisability;
	}

	public void setSevereDisability(boolean severeDisability) {
		this.severeDisability = severeDisability;
	}

	public double calculateDeduction() {
		if (severeDisability) {
			return Math.min(dependentMedicalExpenses, severeDisabilityDeduction);
		} else {
			return Math.min(dependentMedicalExpenses, maximumDeduction);
		}
	}
}
