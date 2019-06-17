package com.example.burgerapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

public class BurgerApi extends BaseApi {

    public BurgerApi() {
    }

    public BurgerApi(BurgerProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(properties, restTemplate, objectMapper);
    }

    public boolean analyzeIsBurger(String url) {
        UriComponentsBuilder uriBuilder = this.buildRequest()
                .path("/recognize");

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    uriBuilder.toUriString(),
                    new BurgerRequest(url),
                    String.class
            );

            return response.getStatusCode().equals(HttpStatus.OK);
        } catch (RestClientException ex) {
            return false;
        }
    }

    static class BurgerRequest {
        private List<String> urls;

        public BurgerRequest(String url) {
            this.urls = Arrays.asList(url);
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(String url) {
            this.urls = Arrays.asList(url);
        }
    }
}
