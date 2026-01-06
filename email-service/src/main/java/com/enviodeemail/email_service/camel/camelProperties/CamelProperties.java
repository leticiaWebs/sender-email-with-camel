package com.enviodeemail.email_service.camel.camelProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelProperties {

    @Value("${mail.from:}")
    public String fromEmail;

    @Value("${mail.smtp.host:}")
    public String smtpHost;

    @Value("${mail.smtp.port:465}")
    public int smtpPort;

    @Value("${mail.smtp.username:}")
    public String smtpUsername;

    @Value("${mail.smtp.password:}")
    public String smtpPassword;

    @Value("${mail.smtp.ssl:false}")
    public boolean useSsl;

    @Value("${mail.smtp.auth:true}")
    public boolean useAuth;

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public boolean isUseSsl() {
        return useSsl;
    }

    public void setUseSsl(boolean useSsl) {
        this.useSsl = useSsl;
    }

    public boolean isUseAuth() {
        return useAuth;
    }

    public void setUseAuth(boolean useAuth) {
        this.useAuth = useAuth;
    }
}
