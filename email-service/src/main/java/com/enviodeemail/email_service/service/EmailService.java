package com.enviodeemail.email_service.service;


import com.enviodeemail.email_service.domain.Email;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final ProducerTemplate producerTemplate;

    public EmailService(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void send(Email email) {
        producerTemplate.sendBody("direct:send-email", email);
    }
}
