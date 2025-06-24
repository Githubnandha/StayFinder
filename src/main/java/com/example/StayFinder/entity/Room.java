package com.example.StayFinder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="room")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,length = 255)
    String address;

    @Column(nullable = false)
    int rent;

    @Column(nullable = false)
    int advance;

    @Column(nullable = false,length = 100)
    String room_type;

    @Column(nullable = false,length = 100)
    String furnish_status;

    @Column(nullable = false)
    int buildup;

    @Column(nullable = false)
    int max_member;

    @Lob
    @Column(name = "image", columnDefinition="LONGBLOB")
    private byte[] image;
}
