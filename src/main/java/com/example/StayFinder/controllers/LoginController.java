package com.example.StayFinder.controllers;


import com.example.StayFinder.entity.User;
import com.example.StayFinder.models.LoginRequest;
import com.example.StayFinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginUser) {
        Optional<User> userOptional = userRepository.findByEmail(loginUser.getEmail());
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            if(passwordEncoder.matches(loginUser.getPassword(),user.getPassword())) {
                System.out.println("Login successful");
                return ResponseEntity.ok("Login successful");
            }
            else {
                System.out.println("Login unsuccessful");
                return ResponseEntity.ok("Invalid password");
            }
        }
        System.out.println("Login unsuccessful");
        return ResponseEntity.badRequest().body("User not found");
    }
}