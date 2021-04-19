package com.cinea.demo.manager;

import com.cinea.demo.dao.repositories.FilmRepository;
import com.cinea.demo.dao.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmManager {

    private FilmRepository filmRepository;

    @Autowired
    public FilmManager(FilmRepository filmRepository) {
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
        //save(new Film(1L,"Film1","Kraków"));
        //new Film();
        //save(new Film(2L,"Film2","Rzeszów"));
        //save(new Film());
        //save(new Film());
    }

}
