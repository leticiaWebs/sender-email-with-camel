package com.enviodeemail.email_service.controller;

import com.enviodeemail.email_service.rest.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        emailService.sendEmail("test@mail.com","Testing Email Service",
                "This is a test email.");
        return "Email sent!";
    }
}
