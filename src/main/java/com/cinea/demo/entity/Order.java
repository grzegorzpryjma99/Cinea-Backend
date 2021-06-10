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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "screening_id", referencedColumnName = "id")
//    private Screening screening;

    @OneToMany
    @JoinColumn(name = "id_order")//TODO sprawdzic ta relacje
    private List<Ticket> tickets;

//    @Column(name = "status")
//    private boolean status;

    public Order() {
    }

    public Order(User user, List<Ticket> tickets) {
        this.user = user;
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
