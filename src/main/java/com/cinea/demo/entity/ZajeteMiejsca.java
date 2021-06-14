package com.cinea.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class ZajeteMiejsca implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        @OneToMany()
        private Set<Place> place;


        public ZajeteMiejsca() {
        }

        public Set<Place> getPlace() {
                return place;
        }

        public ZajeteMiejsca(Set<Place> place) {
                this.place = place;
        }

        public void setPlace(Set<Place> place) {
                this.place = place;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}




