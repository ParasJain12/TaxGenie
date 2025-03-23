package com.taxgenie.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taxgenie.dto.CaseStudyDTO;
import com.taxgenie.dto.FAQdto;
//import com.taxgenie.dto.TaxGuideDTO;
import com.taxgenie.model.FAQCategory;
//import com.taxgenie.model.TaxGuide;
//import com.taxgenie.model.TaxGuideCategory;
//import com.taxgenie.model.CallBackRequest;
import com.taxgenie.model.CaseStudy;
import com.taxgenie.model.CaseStudyCategory;
import com.taxgenie.model.FAQ;
//import com.taxgenie.services.CallBackRequestService;
import com.taxgenie.services.CaseStudyCategoryService;
import com.taxgenie.services.CaseStudyService;
import com.taxgenie.services.FAQCategoryService;
import com.taxgenie.services.FAQService;
//import com.taxgenie.services.TaxGuideCategoryService;
//import com.taxgenie.services.TaxGuideService;

@Controller
public class AdminController {
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img";
	
	@Autowired
	FAQCategoryService faqCategoryService; 
	
	@Autowired
	FAQService faqService;
	
//	@Autowired
//	TaxGuideCategoryService taxGuideCategoryService;
//	
//	@Autowired
//	TaxGuideService taxGuideService;
	
	@Autowired
	CaseStudyCategoryService caseStudyCategoryService;
	
	@Autowired
	CaseStudyService caseStudyService;
	
//	@Autowired
//    private CallBackRequestService callBackRequestService;

	
	@GetMapping("/admin")
	public String adminHome() {
//		List<CallBackRequest> requests = callBackRequestService.getAllRequests();
//        model.addAttribute("requests", requests);
		return "adminHome";
	}
	
	//FAQ Category
	
	@GetMapping("/admin/faqcategories")
	public String getFaqCat(Model model) {
		model.addAttribute("faqcategories", faqCategoryService.getAllCategory());
		return "faqcategories";
	}
	
	@GetMapping("/admin/faqcategories/add")
	public String getFaqCatAdd(Model model) {
		model.addAttribute("faqCategory", new FAQCategory());
		return "faqCategoriesAdd";
	}

	@PostMapping("/admin/faqcategories/add")
	public String postFaqCatAdd(@ModelAttribute("faqCategory") FAQCategory faqCategory) {
		faqCategoryService.addCategory(faqCategory);
		return "redirect:/admin/faqcategories";
	}

	@GetMapping("/admin/faqcategories/delete/{id}")
	public String deleteFaqCat(@PathVariable int id) {
		faqCategoryService.removeCatById(id);
		return "redirect:/admin/faqcategories";
	}

	@GetMapping("/admin/faqcategories/update/{id}")
	public String updateFaqCat(@PathVariable int id, Model model) {
		Optional<FAQCategory> faqCategory = faqCategoryService.getCategoryById(id);
		if (faqCategory.isPresent()) {
			model.addAttribute("faqCategory", faqCategory.get());
			return "faqCategoriesAdd";
		} else
			return "404";
	}
	
	//FAQ
	
	@GetMapping("/admin/faq")
	public String faqs(Model model) {
		model.addAttribute("faq", faqService.getAllFAQ());
		return "faq";
	}
	
	@GetMapping("/admin/faq/add")
	public String faqAddGet(Model model) {
		model.addAttribute("faqDTO", new FAQdto());
		model.addAttribute("faqcategories", faqCategoryService.getAllCategory());
		return "faqAdd";
	}
	
	@PostMapping("/admin/faq/add")
	public String faqAddPost(@ModelAttribute("faqDTO") FAQdto faqDTO) throws IOException {
		FAQ faq = new FAQ();
		faq.setId(faqDTO.getId());
		faq.setQues(faqDTO.getQues());
		faq.setFaqCategory(faqCategoryService.getCategoryById(faqDTO.getFaq_category_id()).get());
		faq.setAnswer(faqDTO.getAnswer());
		faqService.addFAQ(faq);
		return "redirect:/admin/faq";
	}
	
	@GetMapping("/admin/faq/delete/{id}")
	public String deleteFaq(@PathVariable int id) {
		faqService.removeFaqById(id);
		return "redirect:/admin/faq";
	}
	
	@GetMapping("/admin/faq/update/{id}")
	public String updateFaqGet(@PathVariable long id,Model model) {
		FAQ faq = faqService.getFaqById(id).get();
		FAQdto faqDTO = new FAQdto();
		faqDTO.setId(faq.getId());
		faqDTO.setQues(faq.getQues());
		faqDTO.setFaq_category_id(faq.getFaqCategory().getId());
		faqDTO.setAnswer(faq.getAnswer());
		model.addAttribute("faqcategories", faqCategoryService.getAllCategory());
		model.addAttribute("faqDTO", faqDTO);
		return "faqAdd";
	}
	
	/*
	
	//Guide Category
	@GetMapping("/admin/guidecategories")
	public String getCat1(Model model) {
		model.addAttribute("guidecategories", taxGuideCategoryService.getAllBlogCategory());
		return "guidecategories";
	}

	@GetMapping("/admin/guidecategories/add")
	public String getCatAdd1(Model model) {
		model.addAttribute("taxGuideCategory", new TaxGuideCategory());
		return "guidecategoriesAdd";
	}

	@PostMapping("/admin/guidecategories/add")
	public String postCatAdd1(@ModelAttribute("taxGuideCategory") TaxGuideCategory taxGuideCategory) {
		taxGuideCategoryService.addBlogCategory(taxGuideCategory);
		return "redirect:/admin/guidecategories";
	}

	@GetMapping("/admin/guidecategories/delete/{id}")
	public String deleteCat3(@PathVariable int id) {
		taxGuideCategoryService.removeBlogCategoryById(id);
		return "redirect:/admin/guidecategories";
	}

	@GetMapping("/admin/guidecategories/update/{id}")
	public String updateCat1(@PathVariable int id, Model model) {
		Optional<TaxGuideCategory> taxGuideCategory = taxGuideCategoryService.getBlogCategoryById(id);
		if (taxGuideCategory.isPresent()) {
			model.addAttribute("taxGuideCategory", taxGuideCategory.get());
			return "guidecategoriesAdd";
		} else
			return "404";
	}
	
	//Guides 
	@GetMapping("/admin/guideinformation")
	public String bloginformation(Model model) {
		model.addAttribute("guideinformation", taxGuideService.getAllBlogs());
		return "guideinformation";
	}

	@GetMapping("/admin/guideinformation/add")
	public String blogInformationAddGet(Model model) {
		model.addAttribute("taxGuideDTO", new TaxGuideDTO());
		model.addAttribute("taxGuideCategory", taxGuideCategoryService.getAllBlogCategory());
		return "guideinformationAdd";
	}

	@PostMapping("/admin/guideinformation/add")
	public String blogInformationAddPost(@ModelAttribute("taxGuideDTO") TaxGuideDTO taxGuideDTO)
			throws IOException {
		TaxGuide taxGuide = new TaxGuide();
		taxGuide.setId(taxGuideDTO.getId());
		taxGuide.setTitle(taxGuideDTO.getTitle());
		taxGuide.setTaxGuideCategory(taxGuideCategoryService.getBlogCategoryById(taxGuideDTO.getBlog_categoryId()).get());
		taxGuide.setDescription(taxGuideDTO.getDescription());
		taxGuideService.addBlogs(taxGuide);
		return "redirect:/admin/guideinformation";
	}

	@GetMapping("/admin/guideinformation/delete/{id}")
	public String deleteBlogInformation(@PathVariable int id) {
		taxGuideService.removeBlogsById(id);
		return "redirect:/admin/guideinformation";
	}

	@GetMapping("/admin/guideinformation/update/{id}")
	public String updateBlogInformationGet(@PathVariable long id, Model model) {
		TaxGuide taxGuide = taxGuideService.getBlogsById(id).get();
		TaxGuideDTO taxGuideDTO = new TaxGuideDTO();
		taxGuideDTO.setId(taxGuide.getId());
		taxGuideDTO.setTitle(taxGuide.getTitle());
		taxGuideDTO.setBlog_categoryId(taxGuide.getTaxGuideCategory().getId());
		taxGuideDTO.setDescription(taxGuide.getDescription());
		model.addAttribute("guidecategories", taxGuideCategoryService.getAllBlogCategory());
		model.addAttribute("taxGuideDTO", taxGuideDTO);
		return "guideinformationAdd";
	}
	*/
	//Case study category
	@GetMapping("/admin/casestudycategories")
	public String getCat2(Model model) {
		model.addAttribute("casestudycategories", caseStudyCategoryService.getAllCategory());
		return "casestudycategories";
	}

	@GetMapping("/admin/casestudycategories/add")
	public String getCatAdd2(Model model) {
		model.addAttribute("caseStudyCategory", new CaseStudyCategory());
		return "casestudycategoriesAdd";
	}

	@PostMapping("/admin/casestudycategories/add")
	public String postCatAdd2(@ModelAttribute("caseStudyCategory") CaseStudyCategory caseStudyCategory) {
		caseStudyCategoryService.addCategory(caseStudyCategory);
		return "redirect:/admin/casestudycategories";
	}

	@GetMapping("/admin/casestudycategories/delete/{id}")
	public String deleteCat2(@PathVariable int id) {
		caseStudyCategoryService.removeCategoryById(id);
		return "redirect:/admin/casestudycategories";
	}

	@GetMapping("/admin/casestudycategories/update/{id}")
	public String updateCat2(@PathVariable int id, Model model) {
		Optional<CaseStudyCategory> caseStudyCategory = caseStudyCategoryService.getCategoryById(id);
		if (caseStudyCategory.isPresent()) {
			model.addAttribute("caseStudyCategory", caseStudyCategory.get());
			return "casestudycategoriesAdd";
		} else
			return "404";
	}
	
	//Case Study
	@GetMapping("/admin/casestudy")
	public String caseStudy(Model model) {
		model.addAttribute("casestudy", caseStudyService.getAllCaseStudy());
		return "casestudy";
	}

	@GetMapping("/admin/casestudy/add")
	public String caseStudyAddGet(Model model) {
		model.addAttribute("caseStudyDTO", new CaseStudyDTO());
		model.addAttribute("casestudycategories", caseStudyCategoryService.getAllCategory());
		return "caseStudyAdd";
	}

	@PostMapping("/admin/casestudy/add")
	public String caseStudyAddPost(@ModelAttribute("caseStudyDTO") CaseStudyDTO caseStudyDTO,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName) throws IOException {
		CaseStudy caseStudy = new CaseStudy();
		caseStudy.setId(caseStudyDTO.getId());
		caseStudy.setTitle(caseStudyDTO.getTitle());
		caseStudy.setCaseStudyCategory(caseStudyCategoryService.getCategoryById(caseStudyDTO.getCasestudy_categoryId()).get());
		caseStudy.setExample(caseStudyDTO.getExample());
		caseStudy.setDescription(caseStudyDTO.getDescription());
		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		caseStudy.setPhoto(imageUUID);
		caseStudyService.addCaseStudy(caseStudy);
		return "redirect:/admin/casestudy";
	}

	@GetMapping("/admin/casestudy/delete/{id}")
	public String deleteCaseStudy(@PathVariable int id) {
		caseStudyService.removeCaseStudyById(id);
		return "redirect:/admin/casestudy";
	}

	@GetMapping("/admin/casestudy/update/{id}")
	public String updateCaseStudyGet(@PathVariable long id, Model model) {
		CaseStudy caseStudy = caseStudyService.getCaseStudyById(id).get();
		CaseStudyDTO caseStudyDTO = new CaseStudyDTO();
		caseStudyDTO.setId(caseStudy.getId());
		caseStudyDTO.setTitle(caseStudy.getTitle());
		caseStudyDTO.setCasestudy_categoryId(caseStudy.getCaseStudyCategory().getId());
		caseStudyDTO.setExample(caseStudy.getExample());
		caseStudyDTO.setDescription(caseStudy.getDescription());
		caseStudyDTO.setPhoto(caseStudy.getPhoto());
		model.addAttribute("casestudycategories", caseStudyCategoryService.getAllCategory());
		model.addAttribute("caseStudyDTO", caseStudyDTO);
		return "caseStudyAdd";
	}
	
//	//email
//	@GetMapping("/admin")
//    public String viewRequests(Model model) {
//        List<CallBackRequest> requests = callBackRequestService.getAllRequests();
//        model.addAttribute("requests", requests);
//        return "adminHome";
//    }
}
