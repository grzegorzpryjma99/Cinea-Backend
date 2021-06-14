package com.cinea.demo.controllers;

import com.cinea.demo.entity.Ticket;
import com.cinea.demo.entity.User;
import com.cinea.demo.repositories.UserRepository;
import com.cinea.demo.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private UserRepository userRepository;
    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine){
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
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
}