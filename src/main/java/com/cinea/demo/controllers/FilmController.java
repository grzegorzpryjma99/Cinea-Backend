package com.cinea.demo.controllers;

import com.cinea.demo.entity.Film;
import com.cinea.demo.repositories.FilmRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin
@RestController
@RequestMapping("/api/films")
public class FilmController {

    private FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    @GetMapping("/") //http://localhost:8080/api/films/
    public List<Film> getFilms(){
        List<Film> films = new ArrayList<>();
        filmRepository.findAll().forEach(films::add);
        return films;
    }

    @GetMapping("/{id}")
    @Nullable
    public Film getFilm(@PathVariable("id") Long id){
        Film optionalFilm = filmRepository.getOne(id);
        return optionalFilm;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addFilm(@RequestBody Film film){
        film.setFilmDetails(film.getFilmDetails());
        filmRepository.save(film);
        return new ResponseEntity<>("Film added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id){
        filmRepository.deleteById(id);
        return new ResponseEntity<>("Film id = " + id + " deleted successfully", HttpStatus.OK);
    }
}

