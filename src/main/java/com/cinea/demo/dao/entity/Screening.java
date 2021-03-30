package com.cinea.demo.dao.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name ="Screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_screening")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @OneToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @Column(name = "date")
    private String date;//TODO zmienić na Date

    public Screening() {
    }

    public Screening(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
