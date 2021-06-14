package com.cinea.demo.controllers;

import com.cinea.demo.entity.*;
import com.cinea.demo.repositories.OrderRepository;
import com.cinea.demo.repositories.ScreeningRepository;
import com.cinea.demo.repositories.TicketRepository;
import com.cinea.demo.repositories.UserRepository;
import com.cinea.demo.services.EmailSender;
import com.cinea.demo.services.MailService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
    private MailService mailService;
    private UserRepository userRepository;
    private  EmailSender emailSender;
    private  TemplateEngine templateEngine;


    @Autowired
    public OrderController(OrderRepository orderRepository, TicketRepository ticketRepository, ScreeningRepository screeningRepository, MailService mailService, UserRepository userRepository, EmailSender emailSender, TemplateEngine templateEngine) {
        this.orderRepository = orderRepository;
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.mailService = mailService;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
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


        Ticket newTicket = new Ticket(ticket.getTicketTypes(),ticket.getPrice(),screeningRepository.getOne(ticket.getScreening().getId()),ticket.getUserId(),ticket.getPlaceId());
        ticketRepository.save(newTicket);

        return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/sendemail", consumes = "application/json")
    public ResponseEntity<String> send(@RequestBody List<Ticket> ticket){

        Optional<User> user = userRepository.findById(ticket.get(0).getUserId());

        Context context = new Context();
        System.out.println(ticket);
        context.setVariable("header", "Twoje bilety");
        context.setVariable("description", ticket);
        String body = templateEngine.process("template", context);
        emailSender.sendEmail(user.get().getEmail(), "Twoja rezerwacja", body);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/order/add", consumes = "application/json")
    public ResponseEntity<String> addOrder(@RequestBody Order order){

        Order order1 = new Order(order.getUser(),order.getTickets());
        orderRepository.save(order1);
        return new ResponseEntity<>("Order added successfully", HttpStatus.OK);
    }
}
