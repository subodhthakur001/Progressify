package com.example.progressify.service;

import com.example.progressify.entity.User;
import com.example.progressify.exception.DuplicateEntityException;
import com.example.progressify.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new DuplicateEntityException("Username already exists: " + user.getUsername());
        }
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(user.getRole());
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Error while saving the user: " + e.getMessage());
            throw new RuntimeException("Error while saving the user: " + e.getMessage());
        }
    }

}

