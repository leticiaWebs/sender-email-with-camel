package com.enviodeemail.email_service.service;


import com.enviodeemail.email_service.camel.camelProcessor.ValidatorEmailProcessor;
import com.enviodeemail.email_service.domain.Email;
import org.apache.camel.ProducerTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/send")
    public void sendEmail(String to, String body, String subject){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(simpleMailMessage.getTo());
        simpleMailMessage.setSubject(simpleMailMessage.getSubject());
        simpleMailMessage.setText(simpleMailMessage.getText());
        javaMailSender.send(simpleMailMessage);
    }
}
