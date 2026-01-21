package com.enviodeemail.email_service.camel.camelProcessor;
import com.enviodeemail.email_service.domain.Email;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class ValidatorEmailProcessor implements Processor {

    public static final Pattern MALICIUS_PATTERN =
            Pattern.compile("(<script>|</script>|\\$\\(|\\|\\||&&|;|`)", Pattern.CASE_INSENSITIVE);

    public static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    public void process(Exchange exchange) {
        Email email = exchange.getIn().getBody(Email.class);

        if (email.getTo().isBlank()) {
            throw new IllegalArgumentException("Destinatário está vazio");
        }
        if (!EMAIL_PATTERN.matcher(email.getTo()).matches()) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (MALICIUS_PATTERN.matcher(email.getTo()).matches()) {
            throw new IllegalArgumentException("Email contém caracteres maliciosos");
        }
        if(MALICIUS_PATTERN.matcher(email.getSubject()).matches()){
            throw new IllegalArgumentException("Subject contém caracteres maliciosos");
        }

    }
}

