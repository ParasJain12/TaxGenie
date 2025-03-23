package com.taxgenie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxgenie.model.User;
import com.taxgenie.repository.UserRepository;

@Service
public class UserService {
  
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Additional methods like find, delete, etc.
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
    
}