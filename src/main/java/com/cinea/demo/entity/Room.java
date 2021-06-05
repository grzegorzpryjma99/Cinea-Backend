package com.cinea.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="Room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_room")
    private List<Place> places;

    @Column
    private String name;

//    public Screening getScreening() {
//        return screening;
//    }
//
//    public void setScreening(Screening screening) {
//        this.screening = screening;
//    }

//    @JsonIgnore
//    @OneToOne(mappedBy = "room")
//    private Screening screening;

//    @OneToMany()
//    private Set<Screening> screening;

    public Room() {
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Screening> getScreening() {
//        return screening;
//    }
//
//    public void setScreening(Set<Screening> screening) {
//        this.screening = screening;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}