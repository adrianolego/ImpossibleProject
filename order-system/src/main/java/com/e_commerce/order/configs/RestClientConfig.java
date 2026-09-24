package com.e_commerce.order.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(RestClientProperties.class)
public class RestClientConfig {

    @Bean
    public RestClient restClient(
            RestClient.Builder builder,
            RestClientProperties properties
    ) {
        return builder
                .baseUrl(properties.getBaseUrl())
                .build();
    }
}
