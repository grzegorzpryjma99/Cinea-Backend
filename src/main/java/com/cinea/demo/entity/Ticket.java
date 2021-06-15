package com.cinea.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="Ticket")
public class Ticket implements Serializable {

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

    private Long userId;

    private Long placeId;

    public Ticket(TicketTypes ticketTypes, BigDecimal price, Screening screening, Long placeId) {
        this.ticketTypes = ticketTypes;
        this.price = price;
        this.screening = screening;
        this.placeId = placeId;
    }

    public Ticket(TicketTypes ticketTypes, BigDecimal price, Screening screening, Long userId, Long placeId) {
        this.ticketTypes = ticketTypes;
        this.price = price;
        this.screening = screening;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Zakupiłeś bilet " + getTicketTypes() + " w cenie " + getPrice() + " twoje miejsce to " + getId() + " na film " + getScreening();
    }
}
