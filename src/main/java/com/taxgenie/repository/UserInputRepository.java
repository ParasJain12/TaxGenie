package com.taxgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxgenie.model.UserInputForm;

@Repository
public interface UserInputRepository extends JpaRepository<UserInputForm,Long> {

}
