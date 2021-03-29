package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Long id;

    @Column(name = "id_place")
    private Long idPlace;

    public Room() {
    }

    public Room(Long id, Long idPlace) {
        this.id = id;
        this.idPlace = idPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }
}
