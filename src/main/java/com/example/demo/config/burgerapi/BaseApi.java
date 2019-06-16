package com.example.demo.config.burgerapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class BaseApi {

    protected BurgerProperties properties;

    protected RestTemplate restTemplate;

    protected ObjectMapper objectMapper;

    BaseApi() {
    }

    public BaseApi(BurgerProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.properties = properties;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    protected UriComponentsBuilder buildRequest() {
        return UriComponentsBuilder
                .fromUriString(properties.getApiUrl());
    }
}
