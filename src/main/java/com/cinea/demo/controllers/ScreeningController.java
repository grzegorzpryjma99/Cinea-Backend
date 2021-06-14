package com.cinea.demo.controllers;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.Room;
import com.cinea.demo.entity.Screening;
import com.cinea.demo.repositories.FilmRepository;
import com.cinea.demo.repositories.RoomRepository;
import com.cinea.demo.repositories.ScreeningRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {


    private ScreeningRepository screeningRepository;
    private FilmRepository filmRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ScreeningController(ScreeningRepository screeningRepository, FilmRepository filmRepository, RoomRepository roomRepository) {
        this.screeningRepository = screeningRepository;
        this.filmRepository = filmRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/")
    public List<Screening> getScreenings(){
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

    @GetMapping("/{id}")
    @Nullable
    public Optional<Screening> getScreening(@PathVariable("id") Long id){
        Optional<Screening> optionalScreening = screeningRepository.findById(id);
        return optionalScreening;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addScreening(@RequestBody Screening screening){

        Film film1 = filmRepository.getOne(screening.getFilm().getId());
        Room room = roomRepository.getOne(screening.getRoom().getId());
        System.out.println(film1);
        System.out.println(screening.getFilm().getId() + " filmu");
        Screening screening1 = new Screening(film1,room,screening.getDate(), screening.getTime());
        System.out.println( screening.getRoom().getId()+ "roomu");
        System.out.println(room);
        screeningRepository.save(screening1);
        return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteScreening(@PathVariable Long id){
        screeningRepository.deleteById(id);
        return new ResponseEntity<>("Screening id = " + id + " deleted successfully", HttpStatus.OK);
    }
}
