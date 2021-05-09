package com.cinea.demo.dao.controllers;

import com.cinea.demo.dao.entity.Film;
import com.cinea.demo.dao.entity.Screening;
import com.cinea.demo.dao.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningController(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/")
    public List<Screening> getFilms(){
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addScreening(@RequestBody Screening screening){
        screening.setFilm(screening.getFilm());
        screeningRepository.save(screening);
        return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
    }
}
