package com.cinea.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name ="Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_screening")
    private Long idScreening;

    @Column(name = "id_ticket")
    private Long idTicket;

    @Column(name = "status")
    private boolean status;

    public Order() {
    }

    public Order(Long id, Long idUser, Long idScreening, Long idTicket, boolean status) {
        this.id = id;
        this.idUser = idUser;
        this.idScreening = idScreening;
        this.idTicket = idTicket;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(Long idScreening) {
        this.idScreening = idScreening;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
