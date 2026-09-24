package com.e_commerce.order.client;

import com.e_commerce.order.configs.RestClientProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SmsClient {
    private final RestClient restClient;
    private final RestClientProperties properties;

    public SmsClient(RestClient restClient, RestClientProperties properties) {
        this.restClient = restClient;
        this.properties = properties;
    }

    public void sendSms(Long orderId) {
        restClient.post()
                .uri(properties.getSmsUrl(), orderId)
                .retrieve()
                .toBodilessEntity();
    }
}
