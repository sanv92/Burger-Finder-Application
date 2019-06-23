package com.example.foursquareapi.model.venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueGroup {

    private Venue venue;

    public VenueGroup() {}

    public VenueGroup(Venue venue) {
        this.venue = venue;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "VenueGroup{" +
                "venue=" + venue +
                '}';
    }
}
