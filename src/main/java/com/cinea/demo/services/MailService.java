package com.cinea.demo.services;

import com.cinea.demo.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailService {

    private JavaMailSender javaMailSender; // 1
    private List<Ticket> ticketList = new ArrayList<>();

    public MailService() {
    }

    @Autowired
    public MailService(JavaMailSender javaMailSender, List<Ticket> ticketList) {
        this.javaMailSender = javaMailSender;
        this.ticketList = ticketList;
    }

    public void addToList(Ticket ticket){
        ticketList.add(ticket);
    }

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendHtmlEmail(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("Blog example cineaapp@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }

    public void sendSimpleEmail(String to, String subject, List<Ticket> ticket) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("Cinea <cineaapp@gmail.com>");

        msg.setSubject(subject);
        msg.setText(String.valueOf(ticket));

        javaMailSender.send(msg);
    }
}