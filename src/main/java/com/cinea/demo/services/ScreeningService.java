package com.cinea.demo.services;

import com.cinea.demo.entity.*;
import com.cinea.demo.repositories.ScreeningRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import com.cinea.demo.entity.FilmDetails;
import com.cinea.demo.repositories.FilmRepository;

import java.sql.Date;
import java.sql.Time;

@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;
    private FilmRepository filmRepository;


    public Screening save(Screening screening) {
        return screeningRepository.save(screening);
    }

    public Film savef(Film film) {
        return filmRepository.save(film);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){

        FilmDetails filmDetails1 = new FilmDetails(Categories.AKCJA,"Szybcy i wściekli 1", "Policjant przenika do grupy organizującej nielegalne wyścigi samochodowe. Sytuacja komplikuje się, gdy poznaje bliżej siostrę lidera przestępców.",
                "/youtube", Time.valueOf("1:30:00"), Date.valueOf("2001-06-18"));
        Film film1 = new Film(filmDetails1);

        //save(new Film(1L,"Film1","Kraków"));
        //new Film();
        //save(new Film(2L,"Film2","Rzeszów"));
        //save(new Film());
        //save(new Film());

//        System.out.println(film1.getFilmDetails()+ " " + film1.getId());
//        savef(film1);
//        System.out.println(film1.getFilmDetails()+ " " + film1.getId());
//        save(new Screening(film1,new Room(),Date.valueOf("2001-06-18")));


    }
}
