package com.example.foursquareapi.model.venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

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

    public Location() {
    }

    public Location(String address, String crossStreet, String city, String state, String postalCode, String country, String cc, Double lat, Double lng, List<String> formattedAddress) {
        this.address = address;
        this.crossStreet = crossStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.cc = cc;
        this.lat = lat;
        this.lng = lng;
        this.formattedAddress = formattedAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(address, location.address) &&
                Objects.equals(city, location.city) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, country);
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", crossStreet='" + crossStreet + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", cc='" + cc + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", formattedAddress=" + formattedAddress +
                '}';
    }
}
