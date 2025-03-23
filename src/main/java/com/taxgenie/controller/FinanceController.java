package com.taxgenie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taxgenie.dto.CryptoTaxDTO;
import com.taxgenie.dto.GratuityDTO;
import com.taxgenie.dto.SSYDto;
import com.taxgenie.model.CompoundInterestCalculator;
import com.taxgenie.model.CryptoTaxCalculator;
import com.taxgenie.model.EightyCCalculator;
//import com.taxgenie.model.EightyDCalculator;
import com.taxgenie.model.EightyDDCalculator;
import com.taxgenie.model.EightyTTACalculator;
import com.taxgenie.model.EightyUCalculator;
import com.taxgenie.model.GratuityCalculator;
import com.taxgenie.model.HRACalculator;
import com.taxgenie.model.HousePropertyCalculator;
import com.taxgenie.model.NSCCalculator;
//import com.taxgenie.model.IncomeTaxCalculator;
//import com.taxgenie.model.LeaveEncashmentCalculator;
//import com.taxgenie.model.OldVsNewTaxSlabCalculator;
import com.taxgenie.model.SSYCalculator;
import com.taxgenie.model.SimpleInterestCalculator;
import com.taxgenie.model.TDSCalculator;
import com.taxgenie.model.TransportAllowanceCalculator;
import com.taxgenie.services.CompoundInterestService;
import com.taxgenie.services.CryptoTaxService;
import com.taxgenie.services.EightyCService;
import com.taxgenie.services.EightyDDService;
//import com.taxgenie.services.EightyDService;
import com.taxgenie.services.EightyTTAService;
import com.taxgenie.services.EightyUService;
import com.taxgenie.services.GratuityService;
import com.taxgenie.services.HRAService;
import com.taxgenie.services.HousePropertyService;
import com.taxgenie.services.NSCCalculatorService;
//import com.taxgenie.services.IncomeTaxService;
//import com.taxgenie.services.LeaveEncashmentService;
//import com.taxgenie.services.OldVsNewTaxSlabService;
import com.taxgenie.services.SSYService;
import com.taxgenie.services.SimpleInterestService;
import com.taxgenie.services.TDSService;
import com.taxgenie.services.TransportAllowanceService;

@Controller
public class FinanceController {

	@Autowired
    private CompoundInterestService compoundInterestService;
	
	@Autowired
    private CryptoTaxService cryptoTaxService;
	
	@Autowired
	private EightyCService eightyCService;
	
	//@Autowired
    //private EightyDService eightyDService;
	
	@Autowired
    private EightyDDService eightyDDService;

	@Autowired
    private EightyTTAService eightyTTAService;
	
	@Autowired
	private EightyUService eightyUService;
	
	@Autowired
    private GratuityService gratuityService;
	
	@Autowired
	private HousePropertyService housePropertyService;

	@Autowired
	private HRAService hraService;
	
	//@Autowired
	//private IncomeTaxService incomeTaxService; 
	
	//@Autowired
    //private LeaveEncashmentService leaveEncashmentService;
	
	//@Autowired
    //private OldVsNewTaxSlabService taxSlabService;
	
	@Autowired
	private SimpleInterestService simpleInterestService;
	
	@Autowired
    private SSYService ssyService;
	
	@Autowired
    private TDSService tdsService;
	
	@Autowired
    private TransportAllowanceService transportAllowanceService;
	
	@Autowired
	private NSCCalculatorService nscCalculatorService; 

	@GetMapping("/compound-interest-calculator")
    public String showForm1(Model model) {
        model.addAttribute("compoundInterestCalculator", new CompoundInterestCalculator());
        return "compound-interest-calculator";
    }

    @PostMapping("/compound-interest-calculator")
    public String calculate1(CompoundInterestCalculator compoundInterestCalculator, Model model) {
        double compoundInterest = compoundInterestService.calculateCompoundInterest(compoundInterestCalculator);
        model.addAttribute("compoundInterest", compoundInterest);
        return "compound-interest-calculator";
    }
    
    @GetMapping("/crypto-tax-calculator")
    public String showForm2(Model model) {
        model.addAttribute("cryptoTaxDTO", new CryptoTaxDTO());
        model.addAttribute("taxResult", new CryptoTaxCalculator());
        return "crypto-tax-calculator";
    }

    @PostMapping("/crypto-tax-calculator")
    public String calculate2(CryptoTaxDTO cryptoTaxDTO, Model model) {
    	CryptoTaxCalculator result = cryptoTaxService.calculateTax(cryptoTaxDTO);
    	//model.addAttribute("cryptoTaxDTO", new CryptoTaxDTO());
        model.addAttribute("taxResult", result);
        return "crypto-tax-calculator";
    }
    
    @GetMapping("/eightyC-calculator")
	public String showForm3(Model model) {
		model.addAttribute("eightyCCalculator", new EightyCCalculator());
		return "eightyC-calculator";
	}
	
	@PostMapping("/eightyC-calculator")
    public String calculate3(EightyCCalculator eightyCCalculator, Model model) {
        double taxableIncome = eightyCService.calculateTaxableIncome(eightyCCalculator);
        model.addAttribute("taxableIncome", taxableIncome);
        return "eightyC-calculator";
    }
	
	/*
	@GetMapping("/eighty-d-calculator")
    public String showForm4(Model model) {
        model.addAttribute("eightyDCalculator", new EightyDCalculator());
        return "eighty-d-calculator";
    }

    @PostMapping("/eighty-d-calculator")
    public String calculate4(EightyDCalculator eightyDCalculator, Model model) {
        double deduction = eightyDService.calculate80D(eightyDCalculator);
        model.addAttribute("deduction", deduction);
        return "eighty-d-calculator";
    }
    */
    
    @GetMapping("/eightyDD-calculator")
    public String showForm5(Model model) {
        model.addAttribute("eightyDDCalculator", new EightyDDCalculator());
        return "eightyDD-calculator";
    }

    @PostMapping("/eightyDD-calculator")
    public String calculate5(EightyDDCalculator eightyDDCalculator, Model model) {
        double deduction = eightyDDService.calculateDeduction(eightyDDCalculator);
        model.addAttribute("deduction", deduction);
        return "eightyDD-calculator";
    }
    
    @GetMapping("/eighty-tta-calculator")
    public String showForm6(Model model) {
        model.addAttribute("eightyTTACalculator", new EightyTTACalculator());
        return "eighty-tta-calculator";
    }

    @PostMapping("/eighty-tta-calculator")
    public String calculate6(EightyTTACalculator eightyTTACalculator, Model model) {
        double deduction = eightyTTAService.calculate80TTA(eightyTTACalculator);
        model.addAttribute("deduction", deduction);
        return "eighty-tta-calculator";
    }
    
    @GetMapping("/eighty-u-calculator")
	public String showForm7(Model model) {
		model.addAttribute("eightyUCalculator", new EightyUCalculator());
		return "eighty-u-calculator";
	}

	@PostMapping("/eighty-u-calculator")
	public String calculate7(@ModelAttribute("eightyUCalculator") EightyUCalculator eightyUCalculator, Model model) {
		int deduction = eightyUService.calculateDeduction(eightyUCalculator);
        model.addAttribute("deduction", deduction);
        return "eighty-u-calculator";
	}
	
	@GetMapping("/gratuity-calculator")
    public String showForm8(Model model) {
        model.addAttribute("gratuityInput", new GratuityDTO());
        return "gratuity-calculator";
    }

    @PostMapping("/gratuity-calculator")
    public String calculate8(@ModelAttribute GratuityDTO gratuityInput, Model model) {
    	GratuityCalculator result = gratuityService.calculateGratuity(gratuityInput);
    	model.addAttribute("gratuityInput", new GratuityDTO());
        model.addAttribute("result", result);
        return "gratuity-calculator";
    }
    
    @GetMapping("/house-property-calculator")
	public String showForm9(Model model) {
		model.addAttribute("housePropertyCalculator", new HousePropertyCalculator());
		return "house-property-calculator";
	}

	@PostMapping("/house-property-calculator")
	public String calculate9(HousePropertyCalculator housePropertyCalculator, Model model) {
		double incomeFromHouseProperty = housePropertyService.calculateHousePropertyIncome(housePropertyCalculator);
		model.addAttribute("incomeFromHouseProperty", incomeFromHouseProperty);
		return "house-property-calculator";
	}
	
	@GetMapping("/hra-calculator")
	public String showForm10(Model model) {
		model.addAttribute("hraCalculator", new HRACalculator());
		return "hra-calculator";
	}
	
	@PostMapping("/hra-calculator")
    public String calculate10(@ModelAttribute("hraCalculator") HRACalculator hraCalculator, Model model) {
        double hraExemption = hraService.calculateHraExemption(hraCalculator);
        model.addAttribute("hraExemption", hraExemption);
        return "hra-calculator";
    }
	
	/*
	@GetMapping("/income-tax-calculator")
	public String showForm11(Model model) {
		model.addAttribute("incomeTaxCalculator", new IncomeTaxCalculator());
		return "income-tax-calculator";
	}
	
	@PostMapping("/income-tax-calculator")
    public String calculate11(IncomeTaxCalculator incomeTaxCalculator, Model model) {
        double tax = incomeTaxService.calculateTax(incomeTaxCalculator);
        model.addAttribute("tax", tax);
        return "income-tax-calculator";
    }
    
	
	@GetMapping("/leave-encashment-calculator")
    public String showForm12(Model model) {
        model.addAttribute("leaveEncashmentCalculator", new LeaveEncashmentCalculator());
        return "leave-encashment-calculator";
    }

    @PostMapping("/leave-encashment-calculator")
    public String calculate12(LeaveEncashmentCalculator leaveEncashmentCalculator, Model model) {
        double encashment = leaveEncashmentService.calculateLeaveEncashment(leaveEncashmentCalculator);
        model.addAttribute("encashment", encashment);
        return "leave-encashment-calculator";
    }
    
    @GetMapping("/old-vs-new-tax-slab-calculator")
    public String showForm13(Model model) {
        model.addAttribute("oldVsNewTaxSlabCalculator", new OldVsNewTaxSlabCalculator());
        return "old-vs-new-tax-slab-calculator";
    }

    @PostMapping("/old-vs-new-tax-slab-calculator")
    public String calculate13(OldVsNewTaxSlabCalculator oldVsNewTaxSlabCalculator, Model model) {
        double tax = taxSlabService.calculateTax(oldVsNewTaxSlabCalculator);
        model.addAttribute("tax", tax);
        return "old-vs-new-tax-slab-calculator";
    }
    */
    
    @GetMapping("/simple-interest-calculator")
	public String showForm14(Model model) {
		model.addAttribute("simpleInterestCalculator", new SimpleInterestCalculator());
		return "simple-interest-calculator";
	}

	@PostMapping("/simple-interest-calculator")
	public String calculate14(SimpleInterestCalculator simpleInterestCalculator, Model model) {
		double simpleInterest = simpleInterestService.calculateSimpleInterest(simpleInterestCalculator);
		model.addAttribute("simpleInterest", simpleInterest);
		return "simple-interest-calculator";
	}
	
	@GetMapping("/ssy-calculator")
    public String showForm15(Model model) {
		model.addAttribute("ssyDto", new SSYDto());
		 model.addAttribute("calculationResult", new SSYCalculator());
        return "ssy-calculator";
    }

	@PostMapping("/ssy-calculator")
    public String calculate(@Valid @ModelAttribute("ssyDto") SSYDto ssyDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ssyDto", ssyDto);
			model.addAttribute("calculationResult", new SSYCalculator());
            return "ssy-calculator";
        }

        // Perform calculation
        SSYCalculator calculationResult = ssyService.calculateSSY(
                ssyDto.getDateOfBirth(),
                ssyDto.getDepositDate(),
                ssyDto.getYearlyDepositAmount()
        );

        model.addAttribute("ssyDto", ssyDto);
        model.addAttribute("calculationResult", calculationResult);
        return "ssy-calculator";
    }
    
    @GetMapping("/tds-calculator")
    public String showForm16(Model model) {
        model.addAttribute("tdsCalculator", new TDSCalculator());
        return "tds-calculator";
    }

    @PostMapping("/tds-calculator")
    public String calculate16(@ModelAttribute TDSCalculator tdsCalculator, Model model) {
        double tdsAmount = tdsService.calculateTds(tdsCalculator);
        model.addAttribute("tdsAmount", tdsAmount);
        return "tds-calculator";
    }
    
    @GetMapping("/transport-allowance-calculator")
    public String showForm17(Model model) {
        model.addAttribute("transportAllowanceCalculator", new TransportAllowanceCalculator());
        return "transport-allowance-calculator";
    }

    @PostMapping("/transport-allowance-calculator")
    public String calculate17(@ModelAttribute("transportAllowanceCalculator") TransportAllowanceCalculator transportAllowanceCalculator, Model model) {
    	int[] result = transportAllowanceService.calculateTax(transportAllowanceCalculator);
        model.addAttribute("taxFreeAmount", result[0]);
        model.addAttribute("taxableAmount", result[1]);
        return "transport-allowance-calculator";
    }
    
    @GetMapping("/nsc-calculator")
    public String showForm18(Model model) {
        model.addAttribute("nscCalculator", new NSCCalculator());
        return "nsc-calculator";
    }

    @PostMapping("/nsc-calculator")
    public String calculate18(@ModelAttribute("nscCalculator") NSCCalculator nscCalculator, Model model) {
    	double interest = nscCalculatorService.calculateInterest(nscCalculator.getPeriod(), nscCalculator.getInvestmentAmount());
        double deduction = nscCalculatorService.getDeductionUnder80C(nscCalculator.getInvestmentAmount());

        model.addAttribute("interest", interest);
        model.addAttribute("deduction", deduction);

        return "nsc-calculator";
    }
}
