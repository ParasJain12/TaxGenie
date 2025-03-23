package com.taxgenie.model;

public class GratuityCalculator {
	private double exemptedGratuity;
	private double taxableGratuity;

	public GratuityCalculator(double exemptedGratuity, double taxableGratuity) {
		super();
		this.exemptedGratuity = exemptedGratuity;
		this.taxableGratuity = taxableGratuity;
	}

	public double getExemptedGratuity() {
		return exemptedGratuity;
	}

	public void setExemptedGratuity(double exemptedGratuity) {
		this.exemptedGratuity = exemptedGratuity;
	}

	public double getTaxableGratuity() {
		return taxableGratuity;
	}

	public void setTaxableGratuity(double taxableGratuity) {
		this.taxableGratuity = taxableGratuity;
	}

}
