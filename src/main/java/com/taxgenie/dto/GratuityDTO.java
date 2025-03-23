package com.taxgenie.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GratuityDTO {

	@NotNull
	private String employmentType;

	@NotNull
	@Min(value = 0)
	private Double basicPay;

	@NotNull
	@Min(value = 0)
	private Double dearnessAllowance;

	@NotNull
	@Min(value = 0)
	private Integer yearsOfService;

	@NotNull
	@Min(value = 0)
	private Double gratuityReceived;

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public Double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}

	public Double getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(Double dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public Integer getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(Integer yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public Double getGratuityReceived() {
		return gratuityReceived;
	}

	public void setGratuityReceived(Double gratuityReceived) {
		this.gratuityReceived = gratuityReceived;
	}

}
