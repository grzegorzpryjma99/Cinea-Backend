package com.cinea.demo.dao.controllers;

import com.cinea.demo.dao.entity.Film;
import com.cinea.demo.manager.FilmDetailsManager;
import com.cinea.demo.manager.FilmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")   //adres aby dostac sie do API
@CrossOrigin
public class FilmController {


    private FilmManager films;

    @Autowired
    public FilmController(FilmManager films) {
        this.films = films;
    }


    @GetMapping("/all") //http://localhost:8080/api/films/all
    public Iterable<Film> getAll(){
        return films.findAll();
    }

    @GetMapping
    public Optional<Film> getById(@RequestParam Long index){

        return films.findById(index);
    }

    @PostMapping
    public Film addVideo(@RequestBody Film film){
        return films.save(film);
    }

    @PutMapping //przebudowuje elementy
    public Film updateVideo(@RequestBody Film film){
        return films.save(film);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        films.deleteById(index);
    }

}
