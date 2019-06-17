package com.example.foursquareapi;

import com.example.foursquareapi.model.ResponseApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Optional;

public abstract class BaseApi {

    public class FoursquareApiException extends RuntimeException {

        public FoursquareApiException(String message) {
            super(message);
        }

        public FoursquareApiException(Throwable t) {
            super(t);
        }
    }

    protected FoursquareProperties properties;

    protected RestTemplate restTemplate;

    protected ObjectMapper objectMapper;

    BaseApi() {
    }

    public BaseApi(FoursquareProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.properties = properties;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    protected UriComponentsBuilder buildRequest() {
        return UriComponentsBuilder
                .fromUriString(properties.getApiUrl())
                .queryParam("client_id", properties.getClientId())
                .queryParam("client_secret", properties.getClientSecret())
                .queryParam("v", properties.getVersion());
    }

    protected Optional<String> doRequest(UriComponentsBuilder uriBuilder) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(
                    uriBuilder.toUriString(),
                    String.class
            );

            String responseApi = this.handleApiResponse(response).getResponse();
            if (!responseApi.isEmpty()) {
                return Optional.of(responseApi);
            }

            return Optional.empty();
        } catch (RestClientException ex) {
            throw new FoursquareApiException(ex);
        }

    }

    private ResponseApi handleApiResponse(ResponseEntity<String> response) {
        try {
            return new ResponseApi(
                    objectMapper.readTree(response.getBody()).path("response").toString(),
                    response.getStatusCodeValue(),
                    response.getHeaders().toString()
            );
        } catch (IOException ex) {
            throw new FoursquareApiException(ex);
        }
    }
}
