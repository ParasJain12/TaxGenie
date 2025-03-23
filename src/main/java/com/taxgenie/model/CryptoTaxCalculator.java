package com.taxgenie.model;

public class CryptoTaxCalculator {

	private double purchasePrice;
	private double sellingPrice;
	private double profit;
	private double tax;
	private double cess;
	private double totalTaxLiability;

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getCess() {
		return cess;
	}

	public void setCess(double cess) {
		this.cess = cess;
	}

	public double getTotalTaxLiability() {
		return totalTaxLiability;
	}

	public void setTotalTaxLiability(double totalTaxLiability) {
		this.totalTaxLiability = totalTaxLiability;
	}

}
