package com.taxgenie.services;

import org.springframework.stereotype.Service;

@Service
public class NSCCalculatorService {

	public double calculateInterest(String period, double investmentAmount) {
		double interestRate = getInterestRate(period);
		return investmentAmount * interestRate / 100;
	}

	public double getInterestRate(String period) {
		switch (period) {
		case "July 2023 to March 2024":
		case "April 2023 to June 2023":
			return 7.7;
		case "January 2023 to March 2023":
			return 7.0;
		case "April 2022 to December 2022":
		case "April 2021 to March 2022":
		case "April 2020 to March 2021":
			return 6.8;
		case "July 2019 to March 2020":
			return 7.9;
		case "April 2019 to June 2019":
		case "October 2018 to March 2019":
			return 8.0;
		case "April 2018 to September 2018":
		case "January 2018 to March2018":
			return 7.6;
		case "July 2017 to December 2017":
			return 7.8;
		case "April 2017 to June 2017":
		case "October2016 to March 2017":
			return 7.9;
		case "April 2016 to September 2016":
			return 8.1;
		default:
			return 0.0;
		}
	}

	public double getDeductionUnder80C(double investmentAmount) {
		return Math.min(investmentAmount, 150000);
	}
}