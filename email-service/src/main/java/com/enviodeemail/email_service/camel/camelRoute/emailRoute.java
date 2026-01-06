package com.enviodeemail.email_service.camel.camelRoute;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.annotations.Component;
import org.springframework.beans.factory.annotation.Value;

@Component("emailRoute")
public class emailRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from( "seda:sendEmail" )
                .log(LoggingLevel.INFO, "ENVIANDO NOTIFICAÇÃO POR E-MAIL" )
                .to( "smtps://{{spring.mail.host}}:{{spring.mail.port}}?username={{spring.mail.username}}&password={{spring.mail.password}}&mail.smtp.auth=auth&mail.smtp.starttls.enable=starttls" )
                .log(LoggingLevel.INFO, "NOTIFICAÇÃO POR E-MAIL ENVIADA" )
                .stop();
    }

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private  boolean auth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private  boolean starttls;

    }
