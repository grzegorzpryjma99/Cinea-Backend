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

    @Column(name = "id_film")
    private Long idFillm;

    @Column(name = "id_room")
    private Long idRoom;

    @Column(name = "date")
    private String date;//TODO zmienić na Date

    public Screening() {
    }

    public Screening(Long id, Long idFillm, Long idRoom, String date) {
        this.id = id;
        this.idFillm = idFillm;
        this.idRoom = idRoom;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFillm() {
        return idFillm;
    }

    public void setIdFillm(Long idFillm) {
        this.idFillm = idFillm;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
