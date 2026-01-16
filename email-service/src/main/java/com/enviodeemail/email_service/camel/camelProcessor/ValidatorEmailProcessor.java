package com.enviodeemail.email_service.camel.camelProcessor;
import com.enviodeemail.email_service.domain.Email;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class ValidatorEmailProcessor {


    public static final Pattern MALICIUS_PATTERN =
            Pattern.compile("(<script>|</script>|\\$\\(|\\|\\||&&|;|`|<|>)", Pattern.CASE_INSENSITIVE);

    public static final Pattern EMAIL_PATTER =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");



    public void validate(Email email)  {
        validateTo(email.getTo());
        validateSubject(email.getSubject());
        validateBody(email.getBody());
    }

    private void validateTo(String to) {
        if(to == null || to.isBlank())
            throw new IllegalArgumentException("Destinatario está vazio");

        if(!EMAIL_PATTER.matcher(to).matches())
            throw new IllegalArgumentException("Email invalido");

        if(MALICIUS_PATTERN.matcher(to).find())
            throw new IllegalArgumentException("Email contém caracteres maliciosos");
    }

    private void validateSubject(String subject){
        if(subject == null || subject.isBlank())
            throw new IllegalArgumentException("O assunto do email não pode ser vazio");

        if(MALICIUS_PATTERN.matcher(subject).find())
            throw new IllegalArgumentException("Assunto contem conteúdo malicioso");
    }

    private void validateBody(String body){
        if(body == null || body.isBlank())
            throw new IllegalArgumentException("Body não pode ser vazio");
        if(MALICIUS_PATTERN.matcher(body).find())
            throw new IllegalArgumentException("Body contem caracteres maliiosos");
    }

}
