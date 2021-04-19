package com.cinea.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Film_details")
public class FilmDetails implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film_details")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_category")
    private Categories category;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="trailer")
    private String trailer;

    @Column(name="time")
    private String time;

    @Column(name="release_date")
    private String releaseDate;

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public FilmDetails() {
    }

    public FilmDetails(String title, String description, String trailer, String time, String releaseDate) {
        this.title = title;
        this.description = description;
        this.trailer = trailer;
        this.time = time;
        this.releaseDate = releaseDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
