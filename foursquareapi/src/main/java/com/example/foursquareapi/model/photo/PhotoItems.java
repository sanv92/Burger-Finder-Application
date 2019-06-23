package com.example.foursquareapi.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoItems {

    private List<Photo> items;

    public PhotoItems() {}

    public PhotoItems(List<Photo> items) {
        this.items = items;
    }

    public List<Photo> getItems() {
        return items;
    }

    public void setItems(List<Photo> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PhotoItems{" +
                "items=" + items +
                '}';
    }
}
