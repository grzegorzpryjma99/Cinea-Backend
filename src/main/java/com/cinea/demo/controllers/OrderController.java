package com.cinea.demo.controllers;

import com.cinea.demo.entity.*;
import com.cinea.demo.repositories.OrderRepository;
import com.cinea.demo.repositories.ScreeningRepository;
import com.cinea.demo.repositories.TicketRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private TicketRepository ticketRepository;
    private ScreeningRepository screeningRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, TicketRepository ticketRepository, ScreeningRepository screeningRepository) {
        this.orderRepository = orderRepository;
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/tickets/")
    public List<Ticket> getTicket(){
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    @GetMapping("/{id}")
    @Nullable
    public Ticket getTicket(@PathVariable("id") Long id){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.orElse(null);
    }

    @GetMapping("/orders/")
    public List<Order> getOrder(){
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @PostMapping(value = "/tickets/add", consumes = "application/json")
    public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){

        Screening screening = screeningRepository.getOne(ticket.getScreening().getId());
        Ticket newTicket = new Ticket(ticket.getTicketTypes(),ticket.getPrice(),screening,ticket.getPlaceId(),ticket.getPlaceId());
        ticketRepository.save(newTicket);

        return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
    }


//    @GetMapping("/{id}")
//    @Nullable
//    public Order getOrder(@PathVariable("id") Long id){
//        Optional<Order> optionalOrder = orderRepository.findById(id);
//        return optionalOrder.orElse(null);
//    }
//
    @PostMapping(value = "/order/add", consumes = "application/json")
    public ResponseEntity<String> addOrder(@RequestBody Order order){

        Order order1 = new Order(order.getUser(),order.getTickets());
        orderRepository.save(order1);



        return new ResponseEntity<>("Order added successfully", HttpStatus.OK);
    }
}
