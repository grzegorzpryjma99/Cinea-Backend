package com.cinea.demo.controllers;

import com.cinea.demo.entity.Order;
import com.cinea.demo.repositories.OrderRepository;
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

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public List<Order> getOrder(){
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @GetMapping("/{id}")
    @Nullable
    public Order getOrder(@PathVariable("id") Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<>("Order added successfully", HttpStatus.OK);
    }
}
