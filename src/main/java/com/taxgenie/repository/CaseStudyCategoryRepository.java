package com.taxgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxgenie.model.CaseStudyCategory;

@Repository
public interface CaseStudyCategoryRepository extends JpaRepository<CaseStudyCategory,Integer> {

}
