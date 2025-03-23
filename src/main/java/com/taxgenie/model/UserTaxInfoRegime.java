package com.taxgenie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tax_info")
public class UserTaxInfoRegime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double grossSalary;
	private Double standardDeduction;
	private Double hra;
	private Double lta;
	private Double specialAllowances;
	private Double section80CInvestment;
	private Double section80DHealth;
	private Double section80EEducationLoan;
	private Double section80GDonations;
	private Double section80TTASavings;
	private Double homeLoanInterest;
	private Double agriculturalIncome;
	private Double otherExemptions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Double getStandardDeduction() {
		return standardDeduction;
	}

	public void setStandardDeduction(Double standardDeduction) {
		this.standardDeduction = standardDeduction;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getLta() {
		return lta;
	}

	public void setLta(Double lta) {
		this.lta = lta;
	}

	public Double getSpecialAllowances() {
		return specialAllowances;
	}

	public void setSpecialAllowances(Double specialAllowances) {
		this.specialAllowances = specialAllowances;
	}

	public Double getSection80CInvestment() {
		return section80CInvestment;
	}

	public void setSection80CInvestment(Double section80cInvestment) {
		section80CInvestment = section80cInvestment;
	}

	public Double getSection80DHealth() {
		return section80DHealth;
	}

	public void setSection80DHealth(Double section80dHealth) {
		section80DHealth = section80dHealth;
	}

	public Double getSection80EEducationLoan() {
		return section80EEducationLoan;
	}

	public void setSection80EEducationLoan(Double section80eEducationLoan) {
		section80EEducationLoan = section80eEducationLoan;
	}

	public Double getSection80GDonations() {
		return section80GDonations;
	}

	public void setSection80GDonations(Double section80gDonations) {
		section80GDonations = section80gDonations;
	}

	public Double getSection80TTASavings() {
		return section80TTASavings;
	}

	public void setSection80TTASavings(Double section80ttaSavings) {
		section80TTASavings = section80ttaSavings;
	}

	public Double getHomeLoanInterest() {
		return homeLoanInterest;
	}

	public void setHomeLoanInterest(Double homeLoanInterest) {
		this.homeLoanInterest = homeLoanInterest;
	}

	public Double getAgriculturalIncome() {
		return agriculturalIncome;
	}

	public void setAgriculturalIncome(Double agriculturalIncome) {
		this.agriculturalIncome = agriculturalIncome;
	}

	public Double getOtherExemptions() {
		return otherExemptions;
	}

	public void setOtherExemptions(Double otherExemptions) {
		this.otherExemptions = otherExemptions;
	}
}
