package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.UserTaxInfoRegime;

@Service
public class TaxRegimeService {

	public String calculateTaxRegime(UserTaxInfoRegime userTaxInfo) {
		// Standard deduction: Old regime: ₹50,000, New regime: ₹75,000
		double oldRegimeStandardDeduction = 50000;
		double newRegimeStandardDeduction = 75000;

		// Calculate deductions for old regime
		double totalDeductionsOldRegime = userTaxInfo.getSection80CInvestment() + userTaxInfo.getSection80DHealth()
				+ userTaxInfo.getSection80EEducationLoan() + userTaxInfo.getSection80GDonations()
				+ userTaxInfo.getSection80TTASavings() + userTaxInfo.getHomeLoanInterest() + oldRegimeStandardDeduction;

		// Calculate deductions for new regime (Only standard deduction is allowed)
		double totalDeductionsNewRegime = newRegimeStandardDeduction;

		// Gross income - deductions for old and new regime
		double taxableIncomeOldRegime = userTaxInfo.getGrossSalary() - totalDeductionsOldRegime;
		double taxableIncomeNewRegime = userTaxInfo.getGrossSalary() - totalDeductionsNewRegime;

		// Use tax slabs to calculate tax for both regimes
		double taxOldRegime = calculateTaxForOldRegime(taxableIncomeOldRegime);
		double taxNewRegime = calculateTaxForNewRegime(taxableIncomeNewRegime);

		// Compare tax and return the recommendation
		if (taxOldRegime < taxNewRegime) {
			return "Old Tax Regime is beneficial for you.";
		} else {
			return "New Tax Regime is beneficial for you.";
		}
	}

	private double calculateTaxForOldRegime(double taxableIncome) {
		double tax = 0.0;

		// Slab 1: Up to ₹2.5 lakh - No tax
		if (taxableIncome <= 250000) {
			return tax;
		}

		// Slab 2: ₹2.5 lakh - ₹5 lakh - 5% tax
		if (taxableIncome > 250000 && taxableIncome <= 500000) {
			tax = (taxableIncome - 250000) * 0.05;
			return applyCess(tax);
		}

		// Slab 3: ₹5 lakh - ₹10 lakh - 20% tax on income above ₹5 lakh
		if (taxableIncome > 500000 && taxableIncome <= 1000000) {
			tax = (250000 * 0.05) + ((taxableIncome - 500000) * 0.20);
			return applyCess(tax);
		}

		// Slab 4: Above ₹10 lakh - 30% tax on income above ₹10 lakh
		if (taxableIncome > 1000000) {
			tax = (250000 * 0.05) + (500000 * 0.20) + ((taxableIncome - 1000000) * 0.30);
			return applyCess(tax);
		}
	
		return applyCess(tax);
	}

	private double calculateTaxForNewRegime(double taxableIncome) {
		double tax = 0.0;

		// Slab 1: Up to ₹2.5 lakh - No tax
		if (taxableIncome <= 250000) {
			return tax;
		}

		// Slab 2: ₹2.5 lakh - ₹5 lakh - 5% tax
		if (taxableIncome > 250000 && taxableIncome <= 500000) {
			tax = (taxableIncome - 250000) * 0.05;
			return applyCess(tax);
		}

		// Slab 3: ₹5 lakh - ₹7.5 lakh - 10% tax
		if (taxableIncome > 500000 && taxableIncome <= 750000) {
			tax = (250000 * 0.05) + ((taxableIncome - 500000) * 0.10);
			return applyCess(tax);
		}

		// Slab 4: ₹7.5 lakh - ₹10 lakh - 15% tax
		if (taxableIncome > 750000 && taxableIncome <= 1000000) {
			tax = (250000 * 0.05) + (250000 * 0.10) + ((taxableIncome - 750000) * 0.15);
			return applyCess(tax);
		}

		// Slab 5: ₹10 lakh - ₹12.5 lakh - 20% tax
		if (taxableIncome > 1000000 && taxableIncome <= 1250000) {
			tax = (250000 * 0.05) + (250000 * 0.10) + (250000 * 0.15) + ((taxableIncome - 1000000) * 0.20);
			return applyCess(tax);
		}

		// Slab 6: ₹12.5 lakh - ₹15 lakh - 25% tax
		if (taxableIncome > 1250000 && taxableIncome <= 1500000) {
			tax = (250000 * 0.05) + (250000 * 0.10) + (250000 * 0.15) + (250000 * 0.20)
					+ ((taxableIncome - 1250000) * 0.25);
			return applyCess(tax);
		}

		// Slab 7: Above ₹15 lakh - 30% tax
		if (taxableIncome > 1500000) {
			tax = (250000 * 0.05) + (250000 * 0.10) + (250000 * 0.15) + (250000 * 0.20) + (250000 * 0.25)
					+ ((taxableIncome - 1500000) * 0.30);
			return applyCess(tax);
		}

		return applyCess(tax);
	}

	private double applyCess(double tax) {
		// Add 4% health and education cess on total tax
		return tax + (tax * 0.04);
	}

}
