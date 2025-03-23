package com.taxgenie.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.taxgenie.model.UserInputForm;

@Service
public class PdfReportService {

    public File generatePdfReport(UserInputForm userInputForm, String itrForm) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        /*contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Tax Report");
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Recommended ITR Form: " + itrForm);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Income from Salary: " + userInputForm.getIncomeFromSalary());
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Business Income: " + userInputForm.getBusinessIncome());
        contentStream.endText();
        contentStream.close();*/
        
     // "TAXGENIE" in bold sky blue, adjusted position
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
        contentStream.setNonStrokingColor(135, 206, 250); // Sky blue color
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText("TAXGENIE");
        contentStream.endText();

        // "Streamlined Tax Analysis and Savings Platform" in bold sky blue
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 13);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 730);
        contentStream.showText("Streamlined Tax Analysis and Savings Platform");
        contentStream.endText();

        // "Tax Report" centered with larger font and a horizontal line
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
        contentStream.setNonStrokingColor(0, 0, 0); // Reset to black color
        contentStream.beginText();
        float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Tax Report") / 1000 * 24;
        float pageWidth = page.getMediaBox().getWidth();
        contentStream.newLineAtOffset((pageWidth - titleWidth) / 2, 680);
        contentStream.showText("Tax Report");
        contentStream.endText();

        // Add a horizontal line below "Tax Report"
        contentStream.setLineWidth(1f);
        contentStream.moveTo(50, 670);
        contentStream.lineTo(pageWidth - 50, 670);
        contentStream.stroke();

        // Recommended ITR Form in a centered container
        float containerX = 150; // Container X position
        float containerY = 620; // Container Y position
        float containerWidth = 300; // Width of the container
        float containerHeight = 30; // Height of the container

        contentStream.setLineWidth(1f);
        contentStream.addRect(containerX, containerY, containerWidth, containerHeight); // Draw container rectangle
        contentStream.stroke(); // Draw the border

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        float textX = containerX + (containerWidth / 2) - (PDType1Font.HELVETICA_BOLD.getStringWidth("Recommended ITR Form: " + itrForm) / 1000 * 14) / 2;
        contentStream.newLineAtOffset(textX, containerY + (containerHeight / 2) - 7); // Adjust Y to vertically align
        contentStream.showText("Recommended ITR Form: " + itrForm);
        contentStream.endText();

        // Create a table-like structure for income details
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 560);
        contentStream.showText("Income Details:");
        contentStream.endText();

        // Draw income fields as rows
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float incomeRowY = 540;
        String[] incomeLabels = { "Income from Salary:", "Business Income:", "Income from Other Sources:",
        	    "Capital Gains:",
        	    "Foreign Income:",
        	    "Number of House Properties:",
        	    "Agricultural Income:",
        	    "Tax Exemptions:"};
        String[] incomeValues = {
            String.format("%.2f", userInputForm.getIncomeFromSalary()),
            String.format("%.2f", userInputForm.getBusinessIncome()),
            String.format("%.2f", userInputForm.getOtherSourcesIncome()),
            String.format("%.2f", userInputForm.getCapitalGains()),
            String.format("%.2f", userInputForm.getForeignIncome()),
            String.valueOf(userInputForm.getNumberOfHouseProperties()),
            String.format("%.2f", userInputForm.getAgriculturalIncome()),
            String.format("%.2f", userInputForm.getTaxExemptions())
        };

        for (int i = 0; i < incomeLabels.length; i++) {
            contentStream.beginText();
            contentStream.newLineAtOffset(70, incomeRowY);
            contentStream.showText(incomeLabels[i]);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(300, incomeRowY); // Align values to the right
            contentStream.showText(incomeValues[i]);
            contentStream.endText();

            // Draw a line to separate rows
            contentStream.setLineWidth(0.5f);
            contentStream.moveTo(50, incomeRowY - 10);
            contentStream.lineTo(pageWidth - 50, incomeRowY - 10);
            contentStream.stroke();

            incomeRowY -= 30; // Move to the next row
        }

     // Add horizontal line above the date
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(50, 60);
        contentStream.lineTo(pageWidth - 50, 60);
        contentStream.stroke();
        
        // Add current date and time at the bottom-right corner
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTime = now.format(formatter);

        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.beginText();
        float dateTextWidth = PDType1Font.HELVETICA.getStringWidth(currentDateTime) / 1000 * 10;
        contentStream.newLineAtOffset(pageWidth - dateTextWidth - 50, 50); // Position near the bottom-right
        contentStream.showText(currentDateTime);
        contentStream.endText();

        // Close the content stream
        contentStream.close();

        // Save the document in a temporary directory
        File pdfFile = File.createTempFile("Tax_Report", ".pdf");
        document.save(pdfFile);
        document.close();

        return pdfFile; // Return the generated PDF file
    }
}
