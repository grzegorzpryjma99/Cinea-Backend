package com.cinea.demo.controllers;

import com.cinea.demo.entity.Ticket;
import com.cinea.demo.services.MailService;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/mail")
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping(value = "/sendemail", consumes = "application/json")
    public ResponseEntity<String> sendEmail(@RequestBody List<Ticket> ticket) {

        System.out.println(ticket+"tiket");
        mailService.sendSimpleEmail("Odbiorca <"+"grzegorzpryjma@gmail.com"+">", "Rezerwacja", ticket);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @GetMapping("/sendhtmlemail")
    public String sendHtmlEmail() {
        JtwigTemplate emailTemplate = JtwigTemplate.classpathTemplate("C:/Webowe/Cinea2/Cinea-Backend/src/main/java/com/cinea/demo/email.twig");
        JtwigModel model = JtwigModel.newModel()
                .with("username", "MichaÅ‚");

        String emailMessage = emailTemplate.render(model);

        mailService.sendHtmlEmail("Michal grzegorzpryjma@gmail.com", "Test e-mail", emailMessage);

        return "E-mail sent!";
    }
}