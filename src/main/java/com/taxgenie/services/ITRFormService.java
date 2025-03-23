package com.taxgenie.services;

import org.springframework.stereotype.Service;

import com.taxgenie.model.UserInputForm;

@Service
public class ITRFormService {

    public String determineItrForm(UserInputForm inputForm) {
        // Validate inputs before proceeding
        validateInputForm(inputForm);

        // ITR-1 (Sahaj)
        if (isEligibleForItr1(inputForm)) {
            return "ITR-1 (Sahaj)";
        }

        // ITR-2
        if (isEligibleForItr2(inputForm)) {
            return "ITR-2";
        }

        // ITR-3
        if (isEligibleForItr3(inputForm)) {
            return "ITR-3";
        }

        // ITR-4 (Sugam)
        if (isEligibleForItr4(inputForm)) {
            return "ITR-4 (Sugam)";
        }

        // ITR-5
        if (isEligibleForItr5(inputForm)) {
            return "ITR-5";
        }

        // ITR-6
        if (isEligibleForItr6(inputForm)) {
            return "ITR-6";
        }

        // ITR-7
        if (isEligibleForItr7(inputForm)) {
            return "ITR-7";
        }

        // Default return if no ITR form matches
        return "No applicable ITR form based on the provided data. Please review your inputs.";
    }

    // Helper method to check ITR-1 eligibility
    private boolean isEligibleForItr1(UserInputForm inputForm) {
        return (inputForm.getIncomeFromSalary() != null && inputForm.getIncomeFromSalary() <= 5000000) &&
               (inputForm.getNumberOfHouseProperties() != null && inputForm.getNumberOfHouseProperties() == 1) &&
               (inputForm.getOtherSourcesIncome() != null && inputForm.getOtherSourcesIncome() > 0) &&
               (inputForm.getBusinessIncome() == null || inputForm.getBusinessIncome() == 0) &&
               (inputForm.getCapitalGains() == null || inputForm.getCapitalGains() == 0) &&
               (inputForm.getForeignIncome() == null || inputForm.getForeignIncome() == 0) &&
               (inputForm.getAgriculturalIncome() == null || inputForm.getAgriculturalIncome() <= 5000);
    }

    // Helper method to check ITR-2 eligibility
    private boolean isEligibleForItr2(UserInputForm inputForm) {
        return (inputForm.getIncomeFromSalary() != null && inputForm.getIncomeFromSalary() > 5000000) ||
               (inputForm.getNumberOfHouseProperties() != null && inputForm.getNumberOfHouseProperties() > 1) ||
               (inputForm.getCapitalGains() != null && inputForm.getCapitalGains() > 0) ||
               (inputForm.getForeignIncome() != null && inputForm.getForeignIncome() > 0) ||
               (inputForm.getAgriculturalIncome() != null && inputForm.getAgriculturalIncome() > 5000);
    }

    // Helper method to check ITR-3 eligibility
    private boolean isEligibleForItr3(UserInputForm inputForm) {
        return (inputForm.getBusinessIncome() != null && inputForm.getBusinessIncome() > 0) ||
               inputForm.isPartnerInFirm() ||
               (inputForm.getCapitalGains() != null && inputForm.getCapitalGains() > 0) ||
               (inputForm.getForeignIncome() != null && inputForm.getForeignIncome() > 0);
    }

    // Helper method to check ITR-4 eligibility
    private boolean isEligibleForItr4(UserInputForm inputForm) {
        return (inputForm.getBusinessIncome() != null && inputForm.isUnderPresumptiveTaxation()) ||
               (inputForm.getIncomeFromSalary() != null && inputForm.getIncomeFromSalary() > 0) ||
               (inputForm.getNumberOfHouseProperties() != null && inputForm.getNumberOfHouseProperties() == 1);
    }

    // Helper method to check ITR-5 eligibility
    private boolean isEligibleForItr5(UserInputForm inputForm) {
        return inputForm.isFirm() ||
               inputForm.isLlp() ||
               inputForm.isAop() ||
               inputForm.isBoi();
    }

    // Helper method to check ITR-6 eligibility
    private boolean isEligibleForItr6(UserInputForm inputForm) {
        return inputForm.isCompany() && !inputForm.isClaimingExemptionUnderSection11();
    }

    // Helper method to check ITR-7 eligibility
    private boolean isEligibleForItr7(UserInputForm inputForm) {
        return inputForm.isRequiredToFileUnderSection139_4A() ||
               inputForm.isRequiredToFileUnderSection139_4B() ||
               inputForm.isRequiredToFileUnderSection139_4C() ||
               inputForm.isRequiredToFileUnderSection139_4D();
    }

    // Validation method to check null/invalid inputs
    private void validateInputForm(UserInputForm inputForm) {
        if (inputForm.getIncomeFromSalary() != null && inputForm.getIncomeFromSalary() < 0) {
            throw new IllegalArgumentException("Invalid salary input");
        }
        if (inputForm.getBusinessIncome() != null && inputForm.getBusinessIncome() < 0) {
            throw new IllegalArgumentException("Invalid business income input");
        }
        if (inputForm.getAgriculturalIncome() != null && inputForm.getAgriculturalIncome() < 0) {
            throw new IllegalArgumentException("Invalid agricultural income");
        }
        // Additional validations can be added as necessary
    }
}
