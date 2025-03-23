
package com.taxgenie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_input")
public class UserInputForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double incomeFromSalary;
	private Double otherSourcesIncome;
	private Double businessIncome;
	private Double capitalGains;
	private Double foreignIncome;
	private Integer numberOfHouseProperties;
	private Double agriculturalIncome;
	private Double taxExemptions;

	private boolean partnerInFirm;
	private boolean underPresumptiveTaxation;
	private boolean firm;
	private boolean llp;
	private boolean aop;
	private boolean boi;
	private boolean company;
	private boolean claimingExemptionUnderSection11;

	private boolean requiredToFileUnderSection139_4A;
	private boolean requiredToFileUnderSection139_4B;
	private boolean requiredToFileUnderSection139_4C;
	private boolean requiredToFileUnderSection139_4D;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getIncomeFromSalary() {
		return incomeFromSalary;
	}

	public void setIncomeFromSalary(Double incomeFromSalary) {
		this.incomeFromSalary = incomeFromSalary;
	}

	public Double getOtherSourcesIncome() {
		return otherSourcesIncome;
	}

	public void setOtherSourcesIncome(Double otherSourcesIncome) {
		this.otherSourcesIncome = otherSourcesIncome;
	}

	public Double getBusinessIncome() {
		return businessIncome;
	}

	public void setBusinessIncome(Double businessIncome) {
		this.businessIncome = businessIncome;
	}

	public Double getCapitalGains() {
		return capitalGains;
	}

	public void setCapitalGains(Double capitalGains) {
		this.capitalGains = capitalGains;
	}

	public Double getForeignIncome() {
		return foreignIncome;
	}

	public void setForeignIncome(Double foreignIncome) {
		this.foreignIncome = foreignIncome;
	}

	public Integer getNumberOfHouseProperties() {
		return numberOfHouseProperties;
	}

	public void setNumberOfHouseProperties(Integer numberOfHouseProperties) {
		this.numberOfHouseProperties = numberOfHouseProperties;
	}

	public Double getAgriculturalIncome() {
		return agriculturalIncome;
	}

	public void setAgriculturalIncome(Double agriculturalIncome) {
		this.agriculturalIncome = agriculturalIncome;
	}

	public Double getTaxExemptions() {
		return taxExemptions;
	}

	public void setTaxExemptions(Double taxExemptions) {
		this.taxExemptions = taxExemptions;
	}

	public boolean isPartnerInFirm() {
		return partnerInFirm;
	}

	public void setPartnerInFirm(boolean partnerInFirm) {
		this.partnerInFirm = partnerInFirm;
	}

	public boolean isUnderPresumptiveTaxation() {
		return underPresumptiveTaxation;
	}

	public void setUnderPresumptiveTaxation(boolean underPresumptiveTaxation) {
		this.underPresumptiveTaxation = underPresumptiveTaxation;
	}

	public boolean isFirm() {
		return firm;
	}

	public void setFirm(boolean firm) {
		this.firm = firm;
	}

	public boolean isLlp() {
		return llp;
	}

	public void setLlp(boolean llp) {
		this.llp = llp;
	}

	public boolean isAop() {
		return aop;
	}

	public void setAop(boolean aop) {
		this.aop = aop;
	}

	public boolean isBoi() {
		return boi;
	}

	public void setBoi(boolean boi) {
		this.boi = boi;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	public boolean isClaimingExemptionUnderSection11() {
		return claimingExemptionUnderSection11;
	}

	public void setClaimingExemptionUnderSection11(boolean claimingExemptionUnderSection11) {
		this.claimingExemptionUnderSection11 = claimingExemptionUnderSection11;
	}

	public boolean isRequiredToFileUnderSection139_4A() {
		return requiredToFileUnderSection139_4A;
	}

	public void setRequiredToFileUnderSection139_4A(boolean requiredToFileUnderSection139_4A) {
		this.requiredToFileUnderSection139_4A = requiredToFileUnderSection139_4A;
	}

	public boolean isRequiredToFileUnderSection139_4B() {
		return requiredToFileUnderSection139_4B;
	}

	public void setRequiredToFileUnderSection139_4B(boolean requiredToFileUnderSection139_4B) {
		this.requiredToFileUnderSection139_4B = requiredToFileUnderSection139_4B;
	}

	public boolean isRequiredToFileUnderSection139_4C() {
		return requiredToFileUnderSection139_4C;
	}

	public void setRequiredToFileUnderSection139_4C(boolean requiredToFileUnderSection139_4C) {
		this.requiredToFileUnderSection139_4C = requiredToFileUnderSection139_4C;
	}

	public boolean isRequiredToFileUnderSection139_4D() {
		return requiredToFileUnderSection139_4D;
	}

	public void setRequiredToFileUnderSection139_4D(boolean requiredToFileUnderSection139_4D) {
		this.requiredToFileUnderSection139_4D = requiredToFileUnderSection139_4D;
	}
}