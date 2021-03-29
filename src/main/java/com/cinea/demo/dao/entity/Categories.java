package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories")
    private Long id;

    @Column(name = "category")
    private String category; //TODO Zrobić typ enum

    public Categories() {
    }

    public Categories(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
