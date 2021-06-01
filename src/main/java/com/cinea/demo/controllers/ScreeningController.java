package com.cinea.demo.controllers;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.Room;
import com.cinea.demo.entity.Screening;
import com.cinea.demo.repositories.FilmRepository;
import com.cinea.demo.repositories.RoomRepository;
import com.cinea.demo.repositories.ScreeningRepository;
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

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private RoomRepository roomRepository;



    @Autowired
    public ScreeningController(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/")
    public List<Screening> getScreenings(){
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

//    @GetMapping("/{date}")
//    @Nullable
//    public Screening getScreeningsByDate(@PathVariable("date") Timestamp date){
//        Optional<Screening> optionalScreening = screeningRepository.findByDate();
//        return  optionalScreening.orElse(null);
//    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addScreening(@RequestBody Screening screening){

        Film film1 = filmRepository.getOne(screening.getFilm().getId());
        Room room = roomRepository.getOne(screening.getRoom().getId());
        Screening screening1 = new Screening(film1,room,screening.getDateTime());
        screeningRepository.save(screening1);

        return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
    }
}
