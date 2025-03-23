package com.taxgenie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.UserInputForm;
import com.taxgenie.repository.UserInputRepository;

@Service
public class UserInputService {

	@Autowired
	private UserInputRepository userInputRepository;

	public UserInputForm saveUserInput(UserInputForm userInput) {
		return userInputRepository.save(userInput);
	}
}
