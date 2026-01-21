package com.enviodeemail.email_service.controller;

import com.enviodeemail.email_service.domain.Email;
import com.enviodeemail.email_service.service.EmailService;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {


    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String send(@RequestBody Email email) {
        emailService.send(email);
        return "Email enviado para fila Camel.";
    }

}
