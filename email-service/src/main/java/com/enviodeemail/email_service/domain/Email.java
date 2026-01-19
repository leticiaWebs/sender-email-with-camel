package com.enviodeemail.email_service.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Email {

    private String to;
    private String subject;
    private String body;

    public Email(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }


}
