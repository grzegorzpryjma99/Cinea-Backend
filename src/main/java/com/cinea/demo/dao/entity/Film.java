package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Film")
public class Film {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column//(name = "id_film")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_film_details")
    private FilmDetails filmDetails;


    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;
    private String cinema;

    public Film() {
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public Film(Long id, String title, String cinema) {
        this.id = id;
        this.title = title;
        this.cinema = cinema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     */
}
