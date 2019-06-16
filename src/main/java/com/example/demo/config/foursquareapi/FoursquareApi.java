package com.example.demo.config.foursquareapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class FoursquareApi {

    private FoursquareProperties properties;

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    public FoursquareApi() {
    }

    FoursquareApi(
            FoursquareProperties properties,
            RestTemplate restTemplate,
            ObjectMapper objectMapper
    ) {
        this.properties = properties;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public VenueApi venues() {
        return new VenueApi(properties, restTemplate, objectMapper);
    }

    public VenuePhotoApi venuePhotos() {
        return new VenuePhotoApi(properties, restTemplate, objectMapper);
    }
}
