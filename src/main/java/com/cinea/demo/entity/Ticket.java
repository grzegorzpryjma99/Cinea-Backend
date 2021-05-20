package com.cinea.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name ="Ticket")
public class Ticket implements Serializable {
//TODO zrobic relacje Order-ticket
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idRoom;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TicketTypes ticketTypes;

    @Column
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(Long idRoom, TicketTypes ticketTypes, BigDecimal price) {
        this.idRoom = idRoom;
        this.ticketTypes = ticketTypes;
        this.price = price;
    }

    public TicketTypes getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(TicketTypes ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
