package com.enviodeemail.email_service.rest;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Value("${sspring.mail.username}")
    private String from;

    public void sendEmail(String recipient, String subject, String body) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("To", recipient);
        headers.put("From", from);
        headers.put("Subject", subject);
        producerTemplate.sendBodyAndHeaders("seda:sendEmail", body, headers);
    }
}
