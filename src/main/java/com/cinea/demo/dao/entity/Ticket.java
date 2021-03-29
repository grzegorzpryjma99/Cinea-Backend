package com.cinea.demo.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;

    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_room")
    private Long idRoom;

    @Column(name = "type")
    private String type;//TODO zmienic na enum

    @Column(name = "price")
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(Long id, Long idOrder, Long idRoom, String type, BigDecimal price) {
        this.id = id;
        this.idOrder = idOrder;
        this.idRoom = idRoom;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
