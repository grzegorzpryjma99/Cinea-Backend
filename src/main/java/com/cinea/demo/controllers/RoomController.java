package com.cinea.demo.controllers;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.Room;
import com.cinea.demo.entity.Screening;
import com.cinea.demo.repositories.RoomRepository;
import com.cinea.demo.repositories.ScreeningRepository;
import com.sun.istack.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/")
    public List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @GetMapping("/{id}")
    @Nullable
    public Room getRoom(@PathVariable("id") Long id){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElse(null);
    }
}
