package com.taxgenie.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

public class SSYDto {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate depositDate;
	
	@Min(value = 250, message = "Minimum deposit is ₹250")
    @Max(value = 150000, message = "Maximum deposit is ₹1,50,000")
	private double yearlyDepositAmount;

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(LocalDate depositDate) {
		this.depositDate = depositDate;
	}

	public double getYearlyDepositAmount() {
		return yearlyDepositAmount;
	}

	public void setYearlyDepositAmount(double yearlyDepositAmount) {
		this.yearlyDepositAmount = yearlyDepositAmount;
	}

}
