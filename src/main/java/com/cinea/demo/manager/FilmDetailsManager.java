package com.cinea.demo.manager;


import com.cinea.demo.dao.FilmDetailsRepo;
import com.cinea.demo.dao.FilmRepo;
import com.cinea.demo.dao.entity.Film;
import com.cinea.demo.dao.entity.FilmDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmDetailsManager {

    private FilmDetailsRepo filmDetailsRepo;

    @Autowired
    public FilmDetailsManager(FilmDetailsRepo filmRepo) {
        this.filmDetailsRepo = filmRepo;
    }

    public Optional<FilmDetails> findById(Long id) {
        return filmDetailsRepo.findById(id);
    }

    public Iterable<FilmDetails> findAll() {
        return filmDetailsRepo.findAll();
    }

    public FilmDetails save(FilmDetails filmDetails) {
        return filmDetailsRepo.save(filmDetails);
    }

    public void deleteById(Long id) {
        filmDetailsRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        //save(new FilmDetails(1L,"d","das"));
    }

}
