package com.enviodeemail.email_service.camel.camelProcessor;

import com.enviodeemail.email_service.domain.Email;
import com.enviodeemail.email_service.service.EmailService;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component

public class SenderEmailProcessor implements Processor {

    private final JavaMailSender mailSender;

    public SenderEmailProcessor(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        Email email = exchange.getIn().getBody(Email.class);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        mailSender.send(message);
    }
}




