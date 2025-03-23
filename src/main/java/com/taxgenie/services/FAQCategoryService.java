package com.taxgenie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.FAQCategory;
import com.taxgenie.repository.FAQCategoryRepository;

@Service
public class FAQCategoryService {

	@Autowired
	FAQCategoryRepository faqCategoryRepository;

	public void addCategory(FAQCategory faqCategory) {
		faqCategoryRepository.save(faqCategory);
	}

	public List<FAQCategory> getAllCategory() {
		return faqCategoryRepository.findAll();
	}

	public void removeCatById(int id) {
		faqCategoryRepository.deleteById(id);
	}

	public Optional<FAQCategory> getCategoryById(int id) {
		return faqCategoryRepository.findById(id);
	}
}
