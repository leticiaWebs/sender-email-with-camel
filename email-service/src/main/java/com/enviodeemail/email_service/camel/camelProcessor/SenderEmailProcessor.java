package com.enviodeemail.email_service.camel.camelProcessor;

import com.enviodeemail.email_service.domain.Email;
import com.enviodeemail.email_service.service.EmailService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SenderEmailProcessor implements Processor {

    private final EmailService emailService;

    public SenderEmailProcessor(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void process(Exchange exchange){
        Email email = exchange.getIn().getBody(Email.class);

        emailService.sendEmail(
                email.getTo(),
                email.getEmail(),
                email.getBody()
        );
    }

}




