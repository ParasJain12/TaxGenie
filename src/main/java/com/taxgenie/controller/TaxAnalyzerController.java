package com.taxgenie.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.taxgenie.model.UserInputForm;
import com.taxgenie.repository.UserInputRepository;
import com.taxgenie.services.ITRFormService;
import com.taxgenie.services.PdfReportService;

@Controller
public class TaxAnalyzerController {

	@Autowired
    private ITRFormService itrFormService;
	
	@Autowired
	private UserInputRepository userInputRepository;
	
	@Autowired
    private PdfReportService pdfReportService;
	
	@GetMapping("/tax-analyzer")
    public String showTaxAnalyzerForm(Model model) {
        model.addAttribute("userInputForm", new UserInputForm());
        return "tax-analyzer-form";
    }
    
    @PostMapping("/submit-input")
    public String submitUserInput(@Valid @ModelAttribute("userInputForm") UserInputForm userInputForm,
                                  BindingResult bindingResult, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            return "tax-analyzer-form";
        }

        userInputRepository.save(userInputForm);
        String itrForm = itrFormService.determineItrForm(userInputForm);
        model.addAttribute("itrForm", itrForm);

        // Generate the PDF report and get the file
        File pdfFile = pdfReportService.generatePdfReport(userInputForm, itrForm);
        
        // Add the file path for download link
        model.addAttribute("pdfFilePath", pdfFile.getName());

        return "result";
    }
    
    @GetMapping("/download-pdf")
    public ResponseEntity<InputStreamResource> downloadPdf(String pdfFilePath) throws IOException {
        Path pdfPath = Path.of(System.getProperty("java.io.tmpdir"), pdfFilePath);
        InputStreamResource resource = new InputStreamResource(Files.newInputStream(pdfPath));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + pdfFilePath)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}
