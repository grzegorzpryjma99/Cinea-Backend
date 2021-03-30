package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Film_details")
public class FilmDetails {


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

    public FilmDetails() {
    }

    public FilmDetails(String title, String description) {
        this.title = title;
        this.description = description;
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
