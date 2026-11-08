package com.Example.controller;

import com.Example.entity.Room;
import com.Example.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // CREATE ROOM
    @PostMapping
    public Room createRoom(@RequestBody Room room) {

        return roomRepository.save(room);
    }

    // GET ALL ROOMS
    @GetMapping
    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }

    // GET ROOM BY ID
    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {

        return roomRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));
    }
}