package com.cinea.demo.api;

import com.cinea.demo.dao.Film;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")   //adres aby dostac sie do API
@CrossOrigin
public class FilmApi {

    private List<Film> films; //zanim zbuduje baze bede mial liste

    public FilmApi() {
        films = new ArrayList<>();
        films.add(new Film(1L,"Film1"));
        films.add(new Film(2L,"Film2"));
    }

    @GetMapping("/all") //http://localhost:8080/api/films/all
    public List<Film> getAll(){
        return films;
    }

    @GetMapping
    public Film getById(@RequestParam int index){
        Optional<Film> first = films.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addVideo(@RequestBody Film film){
        return films.add(film);
    }

    @PutMapping //przebudowuje elementy
    public boolean updateVideo(@RequestBody Film film){
        return films.add(film);
    }

    @DeleteMapping
    public boolean deleteVideo(@RequestParam int index){
        return films.removeIf(element -> element.getId() == index);
    }

}
