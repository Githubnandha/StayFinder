package com.example.StayFinder.controllers;

import com.example.StayFinder.entity.User;
import com.example.StayFinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User obj = new User();
        System.out.println(user);
        obj.setUsername(user.getUsername());
        obj.setPassword(passwordEncoder.encode(user.getPassword()));
        obj.setEmail(user.getEmail());
        obj.setRole(user.getRole());
        userRepository.save(obj);
        return ResponseEntity.ok(obj.getRole()+" registered successfully");
    }
    @GetMapping("/get")
    public List<User> alluser() {
        return userRepository.findAll();
    }
}
