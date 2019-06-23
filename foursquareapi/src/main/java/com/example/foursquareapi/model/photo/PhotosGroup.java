package com.example.foursquareapi.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotosGroup {

    private PhotoItems photos;

    public PhotosGroup() {
    }

    public PhotosGroup(PhotoItems photos) {
        this.photos = photos;
    }

    public PhotoItems getPhotos() {
        return photos;
    }

    public void setPhotos(PhotoItems photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "PhotosGroup{" +
                "photos=" + photos +
                '}';
    }
}
