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
        validate(email);
    }

    public void validate(Email email) {
        if (email == null) {
            throw new IllegalArgumentException("Email não pode ser nulo");
        }
        validateTo(email.getTo());
        validateSubject(email.getSubject());
        validateBody(email.getBody());
    }

    private void validateTo(String to) {
        if (to == null || to.isBlank())
            throw new IllegalArgumentException("Destinatário está vazio");

        if (!EMAIL_PATTERN.matcher(to).matches())
            throw new IllegalArgumentException("Email inválido");

        if (MALICIUS_PATTERN.matcher(to).find())
            throw new IllegalArgumentException("Email contém caracteres maliciosos");
    }

    private void validateSubject(String subject) {
        if (subject == null || subject.isBlank())
            throw new IllegalArgumentException("O assunto do email não pode ser vazio");

        if (MALICIUS_PATTERN.matcher(subject).find())
            throw new IllegalArgumentException("Assunto contém conteúdo malicioso");
    }

    private void validateBody(String body) {
        if (body == null || body.isBlank())
            throw new IllegalArgumentException("Body não pode ser vazio");

        if (MALICIUS_PATTERN.matcher(body).find())
            throw new IllegalArgumentException("Body contém caracteres maliciosos");
    }

}
