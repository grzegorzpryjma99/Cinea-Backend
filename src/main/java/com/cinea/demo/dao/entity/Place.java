package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place")
    private Long id;

    @Column(name = "id_room")
    private Long idRoom;

    @Column(name = "row")
    private int row;

    @Column(name = "place")
    private int place;

    @Column(name = "acalible")
    private boolean avalible;

    public Place() {
    }

    public Place(Long id, Long idRoom, int row, int place, boolean avalible) {
        this.id = id;
        this.idRoom = idRoom;
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

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
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