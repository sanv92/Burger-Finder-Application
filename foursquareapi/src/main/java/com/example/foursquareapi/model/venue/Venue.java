package com.example.foursquareapi.model.venue;

import com.example.foursquareapi.model.venue.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    private String id;

    private String name;

    private Location location;

    private Category[] categories;

    protected Boolean verified;
}
