package com.enviodeemail.email_service.camel.camelRoute;

import com.enviodeemail.email_service.camel.camelProcessor.SenderEmailProcessor;
import com.enviodeemail.email_service.camel.camelProcessor.ValidatorEmailProcessor;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.annotations.Component;

@Component("")
@AllArgsConstructor
public class EmailRoute extends RouteBuilder {

    private final ValidatorEmailProcessor validatorEmailProcessor;
    private final SenderEmailProcessor senderEmailProcessor;


    @Override
    public void configure() throws Exception {
        from("direct:send-email")
                .routeId("send-email-route")
                .log("Recebido email: ${body}")
                .process(validatorEmailProcessor)
                .process(senderEmailProcessor)
                .log("Email enviado com sucesso para ${body.to}");
    }
}
