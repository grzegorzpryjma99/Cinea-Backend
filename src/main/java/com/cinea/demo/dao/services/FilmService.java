package com.cinea.demo.dao.services;

import com.cinea.demo.dao.entity.Categories;
import com.cinea.demo.dao.entity.Film;
import com.cinea.demo.dao.entity.FilmDetails;
import com.cinea.demo.dao.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Optional<Film> findById(Long id) {
        return filmRepository.findById(id);
    }

    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        /*
        FilmDetails filmDetails1 = new FilmDetails(Categories.AKCJA,"Szybcy i wściekli 1", "Policjant przenika do grupy organizującej nielegalne wyścigi samochodowe. Sytuacja komplikuje się, gdy poznaje bliżej siostrę lidera przestępców.",
                "/youtube", Time.valueOf("1:30:00"), Date.valueOf("2001-06-18"));
        Film film1 = new Film(filmDetails1);
        save(film1);

         */
        //save(new Film(1L,"Film1","Kraków"));
        //new Film();
        //save(new Film(2L,"Film2","Rzeszów"));
        //save(new Film());
        //save(new Film());
    }
}
