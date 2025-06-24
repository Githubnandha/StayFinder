package com.example.StayFinder.entity;

import com.example.StayFinder.models.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, length = 100)
     private String username;

     @Column(nullable = false,length = 255)
     private String password;

     @Column(nullable = false, length = 100)
     private String email;

     @Enumerated(EnumType.STRING)
     @Column(nullable = false)
      private Role role;
}
