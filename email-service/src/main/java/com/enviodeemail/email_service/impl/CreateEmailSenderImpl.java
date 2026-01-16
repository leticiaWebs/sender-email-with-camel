package com.enviodeemail.email_service.impl;

import com.enviodeemail.email_service.repository.CreateEmailSenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CreateEmailSenderImpl implements CreateEmailSenderRepository {
    @Override
    public void createEmail(CreateEmailSenderRepository createEmailSenderRepository, String to) {
        log.info("Email enviado com sucesso, para o destinatario {}", to);
    }
}
