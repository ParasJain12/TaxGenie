package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.TDSCalculator;

@Service
public class TDSService {

	public double calculateTds(TDSCalculator input) {
	        double tdsAmount = 0;
	        double payment = input.getAmountOfPayment();
	        String section = input.getNatureOfPayment();

	        // Define TDS calculation based on the nature of payment (section)
	        switch (section) {
	            case "Section 192A": // Payment of accumulated PF balance to an employee
	                if (payment > 50000) {
	                    tdsAmount = payment * 0.10;
	                }
	                break;

	            case "Section 193": // Interest on securities
	                if (payment > 10000) {
	                    tdsAmount = payment * 0.10;
	                }
	                break;

	            case "Section 194": // Dividend other than dividend under Section 115-O
	                if (payment > 5000) {
	                    tdsAmount = payment * 0.10;
	                }
	                break;

	            case "Section 194A": // Interest other than interest on securities
	                if (payment > 5000) {
	                    tdsAmount = payment * 0.10;
	                }
	                break;

	            case "Section 194B": // Winnings from lotteries
	                if (payment > 10000) {
	                    tdsAmount = payment * 0.30;
	                }
	                break;

	            case "Section 194BB": // Winnings from horse races
	                if (payment > 10000) {
	                    tdsAmount = payment * 0.30;
	                }
	                break;

	            case "Section 194C": // Payment to contractor or sub-contractor
	                if (payment > 100000) {
	                    tdsAmount = payment * 0.01; // 1% for individuals/HUF, 2% for others
	                } else if (payment > 30000) {
	                    tdsAmount = payment * 0.01; // Single transaction limit
	                }
	                break;

	            case "Section 194D": // Insurance commission
	                if (payment > 15000) {
	                    tdsAmount = payment * 0.05;
	                }
	                break;

	            case "Section 194DA": // Payment in respect of life insurance policy
	                if (payment > 100000) {
	                    tdsAmount = payment * 0.05;
	                }
	                break;

	            case "Section 194H": // Commission or brokerage
	                if (payment > 15000) {
	                    tdsAmount = payment * 0.05;
	                }
	                break;

	            case "Section 194I": // Rent
	                if (payment > 240000) {
	                    tdsAmount = payment * 0.10; // 10% for land/building, 2% for plant/machinery
	                }
	                break;

	            case "Section 194IA": // Payment on transfer of immovable property
	                if (payment > 5000000) { // Limit of ₹50 lakh
	                    tdsAmount = payment * 0.01; // 1% of the consideration
	                }
	                break;

	            case "Section 194IB": // Rent by individuals/HUF exceeding ₹50,000 per month
	                if (payment > 50000) {
	                    tdsAmount = payment * 0.05; // 5% TDS on rent
	                }
	                break;

	            case "Section 194J": // Fees for professional or technical services
	                if (payment > 30000) {
	                    tdsAmount = payment * 0.10; // 10% on professional services
	                }
	                break;

	            case "Section 194LA": // Compensation on acquisition of immovable property
	                if (payment > 250000) {
	                    tdsAmount = payment * 0.10;
	                }
	                break;

	            case "Section 194N": // Cash withdrawal above ₹1 crore
	                if (payment > 10000000) { // ₹1 crore limit
	                    tdsAmount = payment * 0.02; // 2% TDS
	                }
	                break;

	            default:
	                // No TDS if the section doesn't match or payment is below the threshold
	                break;
	        }

	        return tdsAmount;
	}
}
