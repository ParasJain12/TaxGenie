package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.dto.CryptoTaxDTO;
import com.taxgenie.model.CryptoTaxCalculator;

@Service
public class CryptoTaxService {

	public CryptoTaxCalculator calculateTax(CryptoTaxDTO dto) {
		CryptoTaxCalculator taxResult = new CryptoTaxCalculator();

        double purchasePrice = dto.getPurchasePrice();
        double sellingPrice = dto.getSellingPrice();
        double profit = sellingPrice - purchasePrice;

        double tax = 0.30 * profit;
        double cess = 0.04 * tax;
        double totalTaxLiability = tax + cess;

        // Set values in CryptoTax model
        taxResult.setPurchasePrice(purchasePrice);
        taxResult.setSellingPrice(sellingPrice);
        taxResult.setProfit(profit);
        taxResult.setTax(tax);
        taxResult.setCess(cess);
        taxResult.setTotalTaxLiability(totalTaxLiability);

        return taxResult;
    }
}
