package com.enviodeemail.email_service;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.annotations.Component;

@Component("")
public class EmailRoute extends RouteBuilder {

    @Override
    public void configure()  {
        from( "direct:send-email")
                .routeId("email-send-route")
                .log("Email enviado para ${body.to}")
                .process("emailProcessor");
    }

}
