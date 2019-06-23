package com.example.foursquareapi.model.venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VenuesGroup {

    private List<Venue> venues;

    public VenuesGroup() {
    }

    public VenuesGroup(List<Venue> venues) {
        this.venues = venues;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public String toString() {
        return "VenuesGroup{" +
                "venues=" + venues +
                '}';
    }
}
