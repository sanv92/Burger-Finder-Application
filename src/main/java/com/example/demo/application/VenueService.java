package com.example.demo.application;

import com.example.demo.config.foursquareapi.FoursquareApi;
import com.example.demo.config.foursquareapi.model.venue.Venue;
import com.example.demo.domain.model.handling.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VenueService {

    private final FoursquareApi foursquareApi;

    @Autowired
    public VenueService(FoursquareApi foursquareApi) {
        this.foursquareApi = foursquareApi;
    }

    public List<Venue> getAllByCity(String cityName) {
        return foursquareApi
                .venues()
                .searchByVenues(
                        cityName,
                        Arrays.asList("4bf58dd8d48988d16c941735", "4bf58dd8d48988d143941735")
                );
    }

    public Venue getById(String venueId) {
        return foursquareApi
                .venues()
                .findById(venueId)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
