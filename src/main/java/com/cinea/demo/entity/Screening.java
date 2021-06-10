package com.cinea.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name ="Screening")
public class Screening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Room room;

    @Column
    private Date date;

    @Column
    private Time time; //TODO many time, many date

    @Column
    @OneToMany
    @JoinColumn(name = "id_screening")
    private List<ZajeteMiejsca> zajeteMiejsca;

    public Screening(Film film, Room room, Date date, Time time) {
        this.film = film;
        this.room = room;
        this.date = date;
        this.time = time;
    }

    public List<ZajeteMiejsca> getZajeteMiejsca() {
        return zajeteMiejsca;
    }

    public void setZajeteMiejsca(List<ZajeteMiejsca> zajeteMiejsca) {
        this.zajeteMiejsca = zajeteMiejsca;
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
