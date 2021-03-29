package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long id;

    @Column(name="id_user_details")
    private Long id_user_details;

    @Column(name = "id_role")
    private Long id_role;

    @Column
    private String email;

    @Column
    private String password;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user_details() {
        return id_user_details;
    }

    public void setId_user_details(Long id_user_details) {
        this.id_user_details = id_user_details;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
