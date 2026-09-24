package com.e_commerce.order.client;

import com.e_commerce.order.configs.RestClientProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Component
public class EmailClient {

    private final RestClient restClient;
    private final RestClientProperties properties;

    public EmailClient(RestClient restClient, RestClientProperties properties) {
        this.restClient = restClient;
        this.properties = properties;
    }

    public void sendEmail(Long orderId) {
        restClient.post()
                .uri(properties.getEmailUrl(), orderId)
                .retrieve()
                .toBodilessEntity();
    }
}
