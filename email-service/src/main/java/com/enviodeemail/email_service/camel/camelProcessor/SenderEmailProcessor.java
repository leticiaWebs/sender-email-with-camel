package com.enviodeemail.email_service.camel.camelProcessor;

import com.enviodeemail.email_service.domain.Email;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SenderEmailProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Email email = exchange.getIn().getBody(Email.class);
        System.out.println("Mock: Email enviado para " + email.getTo()
                + " | Assunto: " + email.getSubject() + " | Corpo: " + email.getBody());
    }
}




