package com.enviodeemail.email_service.controller;

import com.enviodeemail.email_service.domain.Email;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final ProducerTemplate producerTemplate;

   public EmailController(ProducerTemplate producerTemplate){
       this.producerTemplate = producerTemplate;
   }

   @PostMapping
    public void send(@RequestBody Email email){
       producerTemplate.sendBody("direct:send-email", email);
   }

}
