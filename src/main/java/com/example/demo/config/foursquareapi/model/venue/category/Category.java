package com.example.demo.config.foursquareapi.model.venue.category;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Category {

    private String id;

    private String name;

    private String pluralName;

    private String shortName;

    private Icon icon;

    private Boolean primary;
}
