package com.cinea.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="Orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    private Screening screening;

    @OneToMany
    @JoinColumn(name = "id_ticket")//TODO sprawdzic ta relacje
    private List<Ticket> tickets;

    @Column(name = "status")
    private boolean status;

    public Order() {
    }

    public Order(User user, Screening screening, List<Ticket> tickets, boolean status) {
        this.user = user;
        this.screening = screening;
        this.tickets = tickets;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
