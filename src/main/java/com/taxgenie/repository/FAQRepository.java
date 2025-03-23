package com.taxgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.taxgenie.model.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {

	List<FAQ> findAllByFaqCategory_Id(int id);
}
