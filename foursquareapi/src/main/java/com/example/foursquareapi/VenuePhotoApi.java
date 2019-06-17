package com.example.foursquareapi;

import com.example.foursquareapi.model.photo.Photo;
import com.example.foursquareapi.model.photo.PhotosGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VenuePhotoApi extends BaseApi {

    VenuePhotoApi() {
    }

    VenuePhotoApi(FoursquareProperties properties, RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(properties, restTemplate, objectMapper);
    }

    public List<Photo> findById(String venueId, Sort.Direction sort) {
        List<Photo> photos = this.findById(venueId);

        Comparator<Photo> employeeNameComparator = Comparator.comparing(Photo::getCreatedAt);
        Comparator<Photo> photoComparator = sort.isDescending()
                ? employeeNameComparator.reversed()
                : employeeNameComparator;

        photos.sort(photoComparator);

        return photos;
    }

    public List<Photo> findById(String venueId) {
        UriComponentsBuilder uriBuilder = this.buildRequest()
                .path("/venues/")
                .path(venueId)
                .path("/photos");

        Optional<String> response = this.doRequest(uriBuilder);

        try {
            if (response.isPresent()) {
                return objectMapper
                        .readValue(response.get(), PhotosGroup.class)
                        .getPhotos()
                        .getItems();
            }
        } catch (IOException ex) {
            throw new FoursquareApiException(ex);
        }

        return Collections.emptyList();
    }
}
