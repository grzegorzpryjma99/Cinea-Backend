package com.cinea.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Place")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place")
    private Long id;

    @Column(name = "row")
    private int row;

    @Column(name = "place")
    private int place;

//    @Column
//    @OneToMany
//    @JoinColumn(name = "id_place")
//    private List<Ticket> tickets;

//    @Column(name = "acalible")
//    private boolean avalible;

    public Place() {
    }
//
//    public List<Ticket> getTickets() {
//        return tickets;
//    }
//
//    public void setTickets(List<Ticket> tickets) {
//        this.tickets = tickets;
//    }

    public Place(int row, int place) {
        this.row = row;
        this.place = place;

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

//    public boolean isAvalible() {
//        return avalible;
//    }
//
//    public void setAvalible(boolean avalible) {
//        this.avalible = avalible;
//    }
}