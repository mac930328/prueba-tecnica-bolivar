package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${rickmorty.url.base}")
    private String baseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.builder().baseUrl(baseUrl).build();
    }

}
