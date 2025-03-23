package com.taxgenie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.FAQ;
import com.taxgenie.repository.FAQRepository;

@Service
public class FAQService {
	
	@Autowired
	FAQRepository faqRepository;
	
	public List<FAQ> getAllFAQ(){
    	return faqRepository.findAll();
    }
    
    public void addFAQ(FAQ faq) {
    	faqRepository.save(faq);
    }
    
    public void removeFaqById(long id) {
    	faqRepository.deleteById(id);
    }
    
    public Optional<FAQ> getFaqById(long id){
    	return faqRepository.findById(id);
    }
    
    public List<FAQ> getAllFAQByCategoryId(int id){
    	return faqRepository.findAllByFaqCategory_Id(id);
    }
}
