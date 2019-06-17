package com.example.foursquareapi.model.venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String address;

    private String crossStreet;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private String cc;

    private Double lat;

    private Double lng;

    private List<String> formattedAddress;
}
