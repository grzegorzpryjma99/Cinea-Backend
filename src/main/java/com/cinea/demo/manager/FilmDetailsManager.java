package com.cinea.demo.manager;


import com.cinea.demo.dao.repositories.FilmDetailsRepository;
import com.cinea.demo.dao.entity.FilmDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmDetailsManager {

    private FilmDetailsRepository filmDetailsRepository;

    @Autowired
    public FilmDetailsManager(FilmDetailsRepository filmRepo) {
        this.filmDetailsRepository = filmRepo;
    }

    public Optional<FilmDetails> findById(Long id) {
        return filmDetailsRepository.findById(id);
    }

    public Iterable<FilmDetails> findAll() {
        return filmDetailsRepository.findAll();
    }

    public FilmDetails save(FilmDetails filmDetails) {
        return filmDetailsRepository.save(filmDetails);
    }

    public void deleteById(Long id) {
        filmDetailsRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        //save(new FilmDetails(1L,"d","das"));
    }

}
