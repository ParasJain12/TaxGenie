package com.taxgenie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/"})
    public String home(Model model) {
    	return "index";
    }
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		return "about";
	}
	
	@GetMapping("/tax-glossary")
	public String glossary(Model model) {
		return "tax-glossary";
	}
	
	@GetMapping("/service")
	public String service(Model model) {
		return "service";
	}
	
	@GetMapping("/tax-saving")
	public String taxSaving(Model model) {
		return "tax-saving";
	}
	
}
