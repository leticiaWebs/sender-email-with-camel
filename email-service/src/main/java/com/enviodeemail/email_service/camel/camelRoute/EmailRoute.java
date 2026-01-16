package com.enviodeemail.email_service.camel.camelRoute;

import com.enviodeemail.email_service.camel.camelProcessor.ValidatorEmailProcessor;
import com.enviodeemail.email_service.repository.CreateEmailSenderRepository;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.annotations.Component;

@Component("")
public class EmailRoute extends RouteBuilder {

    private final ValidatorEmailProcessor validatorEmailProcessor;
    private final



    @Override
    public void configure() {
        from("direct:send-email")
                .routeId("send-email-route")
                .process()
                .process(senderEmailProcessor)
                .bean(CreateEmailSenderRepository.class)
                .process("emailProcessor");
    }

}
