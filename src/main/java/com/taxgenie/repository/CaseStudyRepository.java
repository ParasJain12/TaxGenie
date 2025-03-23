package com.taxgenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxgenie.model.CaseStudy;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy,Long> {

	List<CaseStudy> findAllByCaseStudyCategoryId(int id);

}
