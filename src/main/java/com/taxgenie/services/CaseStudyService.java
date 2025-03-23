package com.taxgenie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.CaseStudy;
import com.taxgenie.repository.CaseStudyRepository;

@Service
public class CaseStudyService {

	@Autowired
	CaseStudyRepository caseStudyRepository;
	
	public List<CaseStudy> getAllCaseStudy() {
		return caseStudyRepository.findAll();
	}

	public void addCaseStudy(CaseStudy caseStudy) {
		caseStudyRepository.save(caseStudy);
	}

	public void removeCaseStudyById(long id) {
		caseStudyRepository.deleteById(id);
	}

	public Optional<CaseStudy> getCaseStudyById(long id) {
		return caseStudyRepository.findById(id);
	}

	public List<CaseStudy> getAllCaseStudyByCategoryId(int id) {
		return caseStudyRepository.findAllByCaseStudyCategoryId(id);
	}
}
