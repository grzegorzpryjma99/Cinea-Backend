package com.cinea.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name ="Screening")
public class Screening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "film_id", referencedColumnName = "id")
//    private Film film;

    @ManyToOne
    private Film film;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id", referencedColumnName = "id")
//
    @ManyToOne
    private Room room;

//    @Column
//    private Timestamp dateTime;

    @Column
    private Date date;

    @Column
    private Time time; //TODO many time, many date
//    @JsonIgnore
//    @OneToOne(mappedBy = "screening")
//    private Order order;


    public Screening(Film film, Room room, Date date, Time time) {
        this.film = film;
        this.room = room;
        this.date = date;
        this.time = time;
    }






    public Screening() {

    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
