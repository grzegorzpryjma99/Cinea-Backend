package com.cinea.demo.services;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}