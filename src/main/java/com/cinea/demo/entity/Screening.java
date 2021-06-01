package com.cinea.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Table(name ="Screening")
public class Screening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column
    private Timestamp dateTime;

//    @JsonIgnore
//    @OneToOne(mappedBy = "screening")
//    private Order order;

    public Screening(Film film, Room room, Timestamp dateTime) {
        this.film = film;
        this.room = room;
        this.dateTime = dateTime;
    }

    public Screening() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Screening(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
