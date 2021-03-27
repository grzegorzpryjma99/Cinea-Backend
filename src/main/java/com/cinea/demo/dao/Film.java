package com.cinea.demo.dao;

public class Film {

    private Long id;
    private String title;
    private String cinema;

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

    public Film() {
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
}
