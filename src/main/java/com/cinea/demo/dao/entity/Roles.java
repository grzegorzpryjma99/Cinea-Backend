package com.cinea.demo.dao.entity;


import javax.persistence.*;

@Entity
@Table(name ="Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id;

    @Column(name ="user_type")
    private String userType; //TODO Zrobić typ enum

    @OneToOne(mappedBy = "role")
    private User user;

    public Roles() {
    }

    public Roles(String userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
