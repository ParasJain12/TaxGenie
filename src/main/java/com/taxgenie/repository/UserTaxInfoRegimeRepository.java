package com.taxgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxgenie.model.UserTaxInfoRegime;

@Repository
public interface UserTaxInfoRegimeRepository extends JpaRepository<UserTaxInfoRegime, Long> {

}
