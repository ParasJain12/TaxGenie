package com.taxgenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taxgenie.services.CaseStudyCategoryService;
import com.taxgenie.services.CaseStudyService;
import com.taxgenie.services.FAQCategoryService;
import com.taxgenie.services.FAQService;
//import com.taxgenie.services.TaxGuideCategoryService;
//import com.taxgenie.services.TaxGuideService;

@Controller
public class UserController {
	
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
	
	//FAQ
	@GetMapping("/viewfaq")
	public String viewFaq(Model model) {
		model.addAttribute("faqcategories",faqCategoryService.getAllCategory());
		model.addAttribute("faq",faqService.getAllFAQ());
		return "viewfaq";
	}
	
	@GetMapping("/view/faqcategory/{id}")
	public String viewFaqByCategory(Model model,@PathVariable int id) {
		model.addAttribute("faqcategories", faqCategoryService.getAllCategory());
		model.addAttribute("faq", faqService.getAllFAQByCategoryId(id));
		return "viewfaq";
	}
	
	@GetMapping("/viewfaq/viewQues/{id}")
	public String view1(Model model,@PathVariable int id) {
		model.addAttribute("faq", faqService.getFaqById(id).get());
		return "viewQues";
	}
	
	/*Tax Guide
	@GetMapping("/viewblog")
	public String viewBlog(Model model) {
		model.addAttribute("guidecategories", taxGuideCategoryService.getAllBlogCategory());
		model.addAttribute("guideinformation", taxGuideService.getAllBlogs());
		return "viewblog";
	}
	
	@GetMapping("/viewblog/blogcategory/{id}")
	public String viewByBlogCategory(Model model,@PathVariable int id) {
		model.addAttribute("guidecategories", taxGuideCategoryService.getAllBlogCategory());
		model.addAttribute("guideinformation", taxGuideService.getAllBlogsByCategoryId(id));
		return "viewblog";
	}
	
	@GetMapping("/viewblog/viewfinanceblog/{id}")
	public String viewFinanceBlog(Model model,@PathVariable int id) {
		model.addAttribute("guideinformation", taxGuideService.getBlogsById(id).get());
		return "viewfinanceblog";
	}*/
	
	//Case Study
	@GetMapping("/viewcasestudy")
	public String viewCaseStudy(Model model) {
		model.addAttribute("casestudycategories", caseStudyCategoryService.getAllCategory());
		model.addAttribute("casestudy", caseStudyService.getAllCaseStudy());
		return "viewcasestudy";
	}
	
	@GetMapping("/viewcasestudy/casestudycategory/{id}")
	public String viewByCaseStudyCategory(Model model,@PathVariable int id) {
		model.addAttribute("casestudycategories", caseStudyCategoryService.getAllCategory());
		model.addAttribute("casestudy", caseStudyService.getAllCaseStudyByCategoryId(id));
		return "viewcasestudy";
	}
	
	@GetMapping("/viewcasestudy/viewstudy/{id}")
	public String viewCase(Model model,@PathVariable int id) {
		model.addAttribute("casestudy", caseStudyService.getCaseStudyById(id).get());
		return "viewstudy";
	}
}
