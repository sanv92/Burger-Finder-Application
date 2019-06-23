package com.example.foursquareapi.model.venue;

import com.example.foursquareapi.model.venue.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    private String id;

    private String name;

    private Location location;

    private Category[] categories;

    protected Boolean verified;

    public Venue() {
    }

    public Venue(String id, String name, Location location, Category[] categories, Boolean verified) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.categories = categories;
        this.verified = verified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venue)) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id) &&
                Objects.equals(name, venue.name) &&
                Objects.equals(verified, venue.verified);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, verified);
        result = 31 * result + Arrays.hashCode(categories);
        return result;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", categories=" + Arrays.toString(categories) +
                ", verified=" + verified +
                '}';
    }
}
