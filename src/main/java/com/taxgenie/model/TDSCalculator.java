package com.taxgenie.model;

import javax.validation.constraints.PositiveOrZero;

public class TDSCalculator {

	@PositiveOrZero
	private double amountOfPayment;
	private String natureOfPayment;

	public double getAmountOfPayment() {
		return amountOfPayment;
	}

	public void setAmountOfPayment(double amountOfPayment) {
		this.amountOfPayment = amountOfPayment;
	}

	public String getNatureOfPayment() {
		return natureOfPayment;
	}

	public void setNatureOfPayment(String natureOfPayment) {
		this.natureOfPayment = natureOfPayment;
	}

}
