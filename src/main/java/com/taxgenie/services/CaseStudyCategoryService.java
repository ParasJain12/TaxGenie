package com.taxgenie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.CaseStudyCategory;
import com.taxgenie.repository.CaseStudyCategoryRepository;

@Service
public class CaseStudyCategoryService {

	@Autowired
	CaseStudyCategoryRepository caseStudyCategoryRepository;
	
	public void addCategory(CaseStudyCategory caseStudyCategory) {
		caseStudyCategoryRepository.save(caseStudyCategory);
	}
	
	public List<CaseStudyCategory> getAllCategory(){
		return caseStudyCategoryRepository.findAll();
	}
	
	public void removeCategoryById(int id) {
		caseStudyCategoryRepository.deleteById(id);
	}
	
	public Optional<CaseStudyCategory> getCategoryById(int id){
		return caseStudyCategoryRepository.findById(id);
	}
}
