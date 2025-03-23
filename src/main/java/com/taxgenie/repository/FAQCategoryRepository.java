package com.taxgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxgenie.model.FAQCategory;

@Repository
public interface FAQCategoryRepository extends JpaRepository<FAQCategory,Integer> {

}
