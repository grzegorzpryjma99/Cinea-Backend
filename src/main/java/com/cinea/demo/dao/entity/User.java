package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column//(name="id_user")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_user_details")
    private UserDetails userDetails;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Roles role;

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
