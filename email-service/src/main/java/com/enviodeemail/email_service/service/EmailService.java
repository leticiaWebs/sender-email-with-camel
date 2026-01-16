package com.enviodeemail.email_service.service;


import com.enviodeemail.email_service.domain.Email;
import com.enviodeemail.email_service.camel.camelProcessor.ValidatorEmailProcessor;
import org.apache.camel.ProducerTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final ValidatorEmailProcessor validatorEmailProcessor;
    private final ProducerTemplate producerTemplate;

    public EmailService(JavaMailSender javaMailSender, ValidatorEmailProcessor validatorEmailProcessor, ProducerTemplate producerTemplate){
        this.javaMailSender = javaMailSender;
        this.validatorEmailProcessor = validatorEmailProcessor;
        this.producerTemplate = producerTemplate;
    }


    public void sendEmail(Email email){
        validatorEmailProcessor.validate(email);
        producerTemplate.sendBody("direct:send-email", email);
    }
}
