package com.cinea.demo.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Film")
public class Film implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_details_id", referencedColumnName = "id")
    private FilmDetails filmDetails;

    @JsonIgnore
    @OneToOne(mappedBy = "film")
    private Screening screening;

    public Film(FilmDetails filmDetails) {
        this.filmDetails = filmDetails;
    }

    public Film() {
    }

    public FilmDetails getFilmDetails() {
        return filmDetails;
    }

    public void setFilmDetails(FilmDetails filmDetails) {
        this.filmDetails = filmDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
