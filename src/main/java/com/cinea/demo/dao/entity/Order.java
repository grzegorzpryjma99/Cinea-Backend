package com.cinea.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "id_user") //TODO Zrobić relacje!!! jaka tu relacja?
    private Long idUser;

    @OneToOne
    @JoinColumn(name = "id_screening")
    private Screening screening;

    @OneToMany
    @JoinColumn(name = "id_ticket")
    private List<Ticket> tickets;

    @Column(name = "status")
    private boolean status;

    public Order() {
    }

    public Order(Long idUser, Screening screening, List<Ticket> tickets, boolean status) {
        this.idUser = idUser;
        this.screening = screening;
        this.tickets = tickets;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
