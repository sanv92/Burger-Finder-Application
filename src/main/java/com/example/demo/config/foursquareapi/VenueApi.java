package com.example.demo.config.foursquareapi;

import com.example.demo.config.foursquareapi.model.venue.Venue;
import com.example.demo.config.foursquareapi.model.venue.VenueGroup;
import com.example.demo.config.foursquareapi.model.venue.VenuesGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VenueApi extends BaseApi {

    public VenueApi() {
    }

    public VenueApi(FoursquareProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(properties, restTemplate, objectMapper);
    }

    public List<Venue> searchByVenues(
            String near,
            List<String> categoryId
    ) {
        UriComponentsBuilder uriBuilder = this.buildRequest()
                .path("/venues/search")
                .queryParam("near", near)
                .queryParam("categoryId", String.join(",", categoryId))
                .queryParam("intent", "browse");

        Optional<String> response = this.doRequest(uriBuilder);
        try {
            if (response.isPresent()) {
                return objectMapper
                        .readValue(response.get(), VenuesGroup.class)
                        .getVenues();
            }
        } catch (IOException ex) {
            throw new FoursquareApiException(ex);
        }

        return Collections.emptyList();
    }

    public Optional<Venue> findById(String venueId) {
        UriComponentsBuilder uriBuilder = this.buildRequest()
                .path("/venues/")
                .path(venueId);

        try {
            Optional<String> response = this.doRequest(uriBuilder);
            if (response.isPresent()) {
                return Optional.ofNullable(
                        objectMapper
                                .readValue(response.get(), VenueGroup.class)
                                .getVenue()
                );
            }

            return Optional.empty();
        } catch (FoursquareApiException ex) {
            return Optional.empty();
        } catch (IOException ex) {
            throw new FoursquareApiException(ex);
        }
    }
}
