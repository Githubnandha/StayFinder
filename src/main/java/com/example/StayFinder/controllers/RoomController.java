package com.example.StayFinder.controllers;

import com.example.StayFinder.entity.Room;
import com.example.StayFinder.repository.RoomRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class RoomController {
    @Autowired
    RoomRespository roomRespository;

    @PostMapping("/add-room")
    public void addRoom( @RequestParam("rent") int rent,
                        @RequestParam("address") String address,
                        @RequestParam("advance") int advance,
                        @RequestParam("room_type") String roomType,
                        @RequestParam("furnish_status") String furnishStatus,
                        @RequestParam("buildup") int buildup,
                        @RequestParam("max_member") int maxMember,
                        @RequestParam("image") MultipartFile imageFile) throws IOException {
        Room obj = new Room();
        obj.setAddress(address);
        obj.setRent(rent);
        obj.setRoom_type(roomType);
        obj.setBuildup(buildup);
        obj.setAdvance(advance);
        obj.setFurnish_status(furnishStatus);
        obj.setMax_member(maxMember);
        obj.setImage(imageFile.getBytes());
        System.out.println(obj);
        roomRespository.save(obj);
    }

    @GetMapping("/rooms")
    public List<Room> showRooms() {
        return roomRespository.findAll();
    }
}
