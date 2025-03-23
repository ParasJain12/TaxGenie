package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.TransportAllowanceCalculator;

@Service
public class TransportAllowanceService {

	private final int HANDICAPPED_EXEMPTION = 38400;  // Rs. 3200 per month
    private final int NORMAL_EXEMPTION = 19200;       // Rs. 1600 per month

    public int[] calculateTax(TransportAllowanceCalculator dto) {
        int taxFreeAmount;
        int taxableAmount;

        // Determine the tax-free allowance based on whether the assessee is handicapped
        if (dto.isHandicapped()) {
            taxFreeAmount = Math.min(dto.getYearlyTransportAllowance(), HANDICAPPED_EXEMPTION);
        } else {
            taxFreeAmount = Math.min(dto.getYearlyTransportAllowance(), NORMAL_EXEMPTION);
        }

        // Taxable amount is the remaining part of the allowance
        taxableAmount = dto.getYearlyTransportAllowance() - taxFreeAmount;

        return new int[]{taxFreeAmount, taxableAmount};
    }
}
