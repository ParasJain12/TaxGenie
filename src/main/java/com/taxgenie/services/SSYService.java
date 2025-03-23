package com.taxgenie.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.taxgenie.model.SSYCalculator;

@Service
public class SSYService {

	private static final double INTEREST_RATE = 8.40 / 100; // 8.40% annual interest
	private static final int DEPOSIT_YEARS = 14;
    private static final int MATURITY_PERIOD_YEARS = 21;

    public SSYCalculator calculateSSY(LocalDate dateOfBirth, LocalDate depositDate, double yearlyDepositAmount) {
    	 if (yearlyDepositAmount < 250 || yearlyDepositAmount > 150000) {
             throw new IllegalArgumentException("Yearly deposit must be between ₹250 and ₹1,50,000");
         }

         // Total investment for 14 years
         double totalInvestment = yearlyDepositAmount * DEPOSIT_YEARS;

         // Interest calculation: Compound annually for 21 years on deposited amount for 14 years
         double totalInterest = 0;
         double currentPrincipal = 0;

         for (int year = 0; year < MATURITY_PERIOD_YEARS; year++) {
             // Add deposits for the first 14 years
             if (year < DEPOSIT_YEARS) {
                 currentPrincipal += yearlyDepositAmount;
             }

             // Calculate interest for the year
             double interestForYear = currentPrincipal * INTEREST_RATE;
             totalInterest += interestForYear;

             // Add the interest to the principal (compounding)
             currentPrincipal += interestForYear;
         }

         // Maturity amount
         double maturityAmount = totalInvestment + totalInterest;

         // Maturity date
         LocalDate maturityDate = depositDate.plusYears(MATURITY_PERIOD_YEARS);

         // Prepare result
         SSYCalculator result = new SSYCalculator();
         result.setTotalInvestment(totalInvestment);
         result.setTotalInterest(totalInterest);
         result.setMaturityAmount(maturityAmount);
         result.setMaturityDate(maturityDate);

         return result;
     
    }
}
