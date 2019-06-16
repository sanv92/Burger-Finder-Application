package com.example.demo.application;

import com.example.demo.config.foursquareapi.FoursquareApi;
import com.example.demo.config.foursquareapi.model.photo.Photo;
import com.example.demo.domain.model.BurgerPhoto;
import com.example.demo.domain.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenuePhotoService {

    private final FoursquareApi foursquareApi;

    private final PhotoService photoService;

    private final VenuePhotoAnalyzerService venuePhotoAnalyzerService;

    @Autowired
    public VenuePhotoService(
            FoursquareApi foursquareApi,
            PhotoService photoService,
            VenuePhotoAnalyzerService venuePhotoAnalyzerService
    ) {
        this.foursquareApi = foursquareApi;
        this.photoService = photoService;
        this.venuePhotoAnalyzerService = venuePhotoAnalyzerService;
    }

    public List<Photo> getPhotos(String venueId) {
        return foursquareApi
                .venuePhotos()
                .findById(venueId, Sort.Direction.DESC);
    }

    public BurgerPhoto getLastPhoto(String venueId) {
        List<Photo> photos = this.getPhotos(venueId);

        if (!photos.isEmpty()) {
            Photo photo = photos.get(0);

            BurgerPhoto burgerPhoto = photoService.createPhoto(
                    new BurgerPhoto(photo.getId(), photo.getCreatedAt()),
                    photo.getPrefix(), photo.getSuffix(), photo.getHeight(), photo.getWidth()
            );

            burgerPhoto.setBurger(
                    venuePhotoAnalyzerService.isBurger(burgerPhoto.getUrl())
            );

            return burgerPhoto;
        }

        return new BurgerPhoto();
    }
}
