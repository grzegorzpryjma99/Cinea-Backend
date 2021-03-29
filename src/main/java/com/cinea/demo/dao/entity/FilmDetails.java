package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Film_details")
public class FilmDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film_details")
    private Long id;

    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public FilmDetails() {
    }

    public FilmDetails(Long id, Long idCategory, String title, String description) {
        this.id = id;
        this.idCategory = idCategory;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
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
