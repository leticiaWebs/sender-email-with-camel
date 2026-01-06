package com.enviodeemail.email_service.camel.camelProcessor;

import com.enviodeemail.email_service.camel.camelProperties.CamelProperties;
import com.enviodeemail.email_service.domain.Subscriber;
import com.enviodeemail.email_service.repository.SubscriberRespository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SenderEmailProcessor implements Processor {

    private static final Logger log = LoggerFactory.getLogger(SenderEmailProcessor.class);

    private final SubscriberRespository subscriberRespository;
    private final CamelProperties properties;

    public SenderEmailProcessor(SubscriberRespository subscriberRespository, CamelProperties properties) {
        this.subscriberRespository = subscriberRespository;
        this.properties = properties;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Subscriber> subscribers = subscriberRespository.findAll();

        for (Subscriber subscriber : subscribers){
            StringBuilder uri = new StringBuilder(properties.useSsl ? "smtps://" : "smtp://");
            uri.append(properties.smtpHost).append(":").append(properties.smtpPort)
                    .append("?username=").append(properties.smtpUsername)
                    .append("&password=").append(properties.smtpPassword)
                    .append("&from=").append(properties.fromEmail)
                    .append("&to=").append(subscriber.getEmail())
                    .append("&subject=").append("Email teste ")
                    .append("&contentType=text/plain");

            if(properties.useAuth) uri.append("&mail.smtp.auth=true");
            if(properties.useSsl) uri.append("&mail.smtp.ssl.enable=true");

            try(ProducerTemplate producerTemplate = exchange.getContext().createProducerTemplate()){
                log.info("Email enviado com sucesso {}", subscriber.getEmail());

                producerTemplate.sendBody(uri.toString(),
                        "Olá, esse email é um teste!");

            }

        }
    }


}
