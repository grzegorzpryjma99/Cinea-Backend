package com.cinea.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Place")
public class Place implements Serializable {
//TODO Zrobić relacje dla Place-Room
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place")
    private Long id;

    @Column(name = "row")
    private int row;

    @Column(name = "place")
    private int place;

    @Column(name = "acalible")
    private boolean avalible;

    public Place() {
    }

    public Place(int row, int place, boolean avalible) {
        this.row = row;
        this.place = place;
        this.avalible = avalible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isAvalible() {
        return avalible;
    }

    public void setAvalible(boolean avalible) {
        this.avalible = avalible;
    }
}