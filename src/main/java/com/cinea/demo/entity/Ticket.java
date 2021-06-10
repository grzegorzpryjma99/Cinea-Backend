package com.cinea.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="Ticket")
public class Ticket implements Serializable {
//TODO zrobic relacje Order-ticket
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TicketTypes ticketTypes;

    @Column
    private BigDecimal price;

    @ManyToOne
    private Screening screening;

    private Long orderId;

    private Long placeId;
//    @Column
//    @ManyToOne
//    //@JoinColumn(name = "id_place")
//    private Ticket ticket;

    public Ticket(TicketTypes ticketTypes, BigDecimal price, Screening screening, Long placeId) {
        this.ticketTypes = ticketTypes;
        this.price = price;
        this.screening = screening;
        this.placeId = placeId;
    }

    public Ticket(TicketTypes ticketTypes, BigDecimal price, Screening screening, Long orderId, Long placeId) {
        this.ticketTypes = ticketTypes;
        this.price = price;
        this.screening = screening;
        this.orderId = orderId;
        this.placeId = placeId;
    }

    public Ticket() {
    }

    public Ticket(TicketTypes ticketTypes, BigDecimal price) {
        this.ticketTypes = ticketTypes;
        this.price = price;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
