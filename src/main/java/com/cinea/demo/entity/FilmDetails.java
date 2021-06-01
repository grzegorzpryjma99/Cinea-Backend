package com.cinea.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name ="Film_details")
public class FilmDetails implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String trailer;

    @Column
    private Time time;

    @Column
    private Date releaseDate;

    @Column
    private String imageURL;

    @JsonIgnore
    @OneToOne(mappedBy = "filmDetails")
    private Film film;



    public FilmDetails(Categories category, String title, String description, String trailer, Time time, Date releaseDate, String imageURL) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.trailer = trailer;
        this.time = time;
        this.releaseDate = releaseDate;
        this.film = film;
        this.imageURL = imageURL;
    }

    public FilmDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Film getFilm() {
        return film;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
