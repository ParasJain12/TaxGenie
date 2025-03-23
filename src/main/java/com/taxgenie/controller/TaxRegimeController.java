package com.taxgenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taxgenie.model.UserTaxInfoRegime;
import com.taxgenie.repository.UserTaxInfoRegimeRepository;
import com.taxgenie.services.TaxRegimeService;

@Controller
public class TaxRegimeController {

	@Autowired
	private TaxRegimeService taxRegimeService;
	
	@Autowired
	private UserTaxInfoRegimeRepository userTaxInfoRegimeRepository;
	
	@GetMapping("/tax-regime-form")
    public String showTaxForm(Model model) {
        model.addAttribute("userTaxInfo", new UserTaxInfoRegime());
        return "tax-regime-form";
    }

    @PostMapping("/calculate-tax-regime")
    public String calculateTax(@ModelAttribute UserTaxInfoRegime userTaxInfo, Model model) {
        // Save user inputs
    	userTaxInfoRegimeRepository.save(userTaxInfo);

        // Calculate best tax regime
        String recommendation = taxRegimeService.calculateTaxRegime(userTaxInfo);

        // Pass the recommendation to the view
        model.addAttribute("recommendation", recommendation);
        return "regimeresult";
    }
}
