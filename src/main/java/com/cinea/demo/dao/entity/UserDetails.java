package com.cinea.demo.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="User_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_user_details")
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String birthday; //TODO zmienić na Date

    @Column
    private Long phone;

    public UserDetails() {
    }

    public UserDetails(String name, String surname, String birthday, Long phone) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
