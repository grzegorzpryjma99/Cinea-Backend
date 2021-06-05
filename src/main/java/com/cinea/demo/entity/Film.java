package com.cinea.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Film")
public class Film implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_details_id", referencedColumnName = "id")
    private FilmDetails filmDetails;

//    @JsonIgnore
//    @OneToOne(mappedBy = "film")
//    private Screening screening;

//    @OneToMany()
//    private Set<Screening> screening;

//TODO pusty screening tu jest + tak samo w room
    public Film(FilmDetails filmDetails) {
        this.filmDetails = filmDetails;
    }

    public Film() {
    }

    public FilmDetails getFilmDetails() {
        return filmDetails;
    }

//    public Screening getScreening() {
//        return screening;
//    }
//
//    public void setScreening(Screening screening) {
//        this.screening = screening;
//    }

    public void setFilmDetails(FilmDetails filmDetails) {
        this.filmDetails = filmDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



//    public Set<Screening> getScreening() {
//        return screening;
//    }
//
//    public void setScreening(Set<Screening> screening) {
//        this.screening = screening;
//    }
}
