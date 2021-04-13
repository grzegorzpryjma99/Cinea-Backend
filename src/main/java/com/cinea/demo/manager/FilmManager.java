package com.cinea.demo.manager;

import com.cinea.demo.dao.repositories.FilmRepo;
import com.cinea.demo.dao.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmManager {

    private FilmRepo filmRepo;

    @Autowired
    public FilmManager(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    public Optional<Film> findById(Long id) {
        return filmRepo.findById(id);
    }

    public Iterable<Film> findAll() {
        return filmRepo.findAll();
    }

    public Film save(Film film) {
        return filmRepo.save(film);
    }

    public void deleteById(Long id) {
        filmRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        //save(new Film(1L,"Film1","Kraków"));
        //save(new Film(2L,"Film2","Rzeszów"));
        //save(new Film());
        //save(new Film());
    }

}
