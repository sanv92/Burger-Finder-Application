package com.example.burgerapi;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class BaseApi {

    protected BurgerProperties properties;

    protected RestTemplate restTemplate;

    BaseApi() {
    }

    public BaseApi(BurgerProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    protected UriComponentsBuilder buildRequest() {
        return UriComponentsBuilder
                .fromUriString(properties.getApiUrl());
    }
}
