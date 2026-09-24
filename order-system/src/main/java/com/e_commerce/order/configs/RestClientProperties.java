package com.e_commerce.order.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "services")
public final class RestClientProperties {

    private final String baseUrl;
    private final String emailUrl;
    private final String smsUrl;

    @ConstructorBinding
    public RestClientProperties(String baseUrl, String emailUrl, String smsUrl) {
        this.baseUrl = baseUrl;
        this.emailUrl = emailUrl;
        this.smsUrl = smsUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public String getSmsUrl() {
        return smsUrl;
    }
}
