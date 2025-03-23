package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.dto.GratuityDTO;
import com.taxgenie.model.GratuityCalculator;

@Service
public class GratuityService {

	private static final double MAX_EXEMPTION = 20000000; // ₹20,00,000

	public GratuityCalculator calculateGratuity(GratuityDTO input) {
		double lastDrawnSalary = input.getBasicPay() + input.getDearnessAllowance();
		double exemptedGratuity = 0;
		double taxableGratuity;

		switch (input.getEmploymentType()) {
		case "Government":
			exemptedGratuity = input.getGratuityReceived(); // Fully exempt
			break;
		case "Gratuity Act Applies":
			double calculatedGratuity = (input.getYearsOfService() * 15 / 26) * lastDrawnSalary;
			exemptedGratuity = Math.min(Math.min(input.getGratuityReceived(), MAX_EXEMPTION), calculatedGratuity);
			break;
		case "Gratuity Act Does Not Apply":
			double averageSalary = lastDrawnSalary; // Simplified for this example
			calculatedGratuity = 0.5 * averageSalary * input.getYearsOfService();
			exemptedGratuity = Math.min(Math.min(input.getGratuityReceived(), MAX_EXEMPTION), calculatedGratuity);
			break;
		}

		taxableGratuity = input.getGratuityReceived() - exemptedGratuity;

		return new GratuityCalculator(exemptedGratuity, taxableGratuity);
	}
}
