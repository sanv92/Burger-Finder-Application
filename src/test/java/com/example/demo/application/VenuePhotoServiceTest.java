package com.example.demo.application;

import com.example.demo.config.foursquareapi.FoursquareApi;
import com.example.demo.config.foursquareapi.model.photo.Photo;
import com.example.demo.domain.model.BurgerPhoto;
import com.example.demo.domain.service.PhotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Sort;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class VenuePhotoServiceTest {

    @Mock
    private PhotoService photoService;

    @Mock
    private VenuePhotoAnalyzerService venuePhotoAnalyzerService;

    private FoursquareApi foursquareApi;

    private VenuePhotoService venuePhotoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        this.foursquareApi = Mockito.mock(FoursquareApi.class, Mockito.RETURNS_DEEP_STUBS);
        this.venuePhotoService = new VenuePhotoService(foursquareApi, photoService, venuePhotoAnalyzerService);
    }

    @Test
    void getPhotos() {
        when(foursquareApi.venuePhotos().findById(anyString(), any(Sort.Direction.class)))
                .thenReturn(Arrays.asList(new Photo(), new Photo()));

        List<Photo> expectedResult = venuePhotoService.getPhotos("testId");

        assertEquals(expectedResult, Arrays.asList(new Photo(), new Photo()));
        verify(foursquareApi.venuePhotos()).findById("testId", Sort.Direction.DESC);
    }

    @Test
    @Description("should return empty burger photo object, if no photos was found")
    void getLastPhoto_NotFoundPhoto() {
        final VenuePhotoService venuePhotoService = spy(this.venuePhotoService);

        doReturn(Collections.emptyList())
                .when(venuePhotoService).getPhotos(anyString());

        BurgerPhoto expectedResult = venuePhotoService.getLastPhoto("testId");

        verify(venuePhotoService).getPhotos("testId");
        assertEquals(expectedResult, new BurgerPhoto());
    }

    @Test
    @Description("should return burger photo object with url, if photos was found")
    void getLastPhoto_FoundPhoto() {
        final VenuePhotoService venuePhotoService = spy(this.venuePhotoService);

        String imageUrl = "/image-url.jpg";
        Long createdAt = Instant.now().toEpochMilli();
        BurgerPhoto burgerPhoto = new BurgerPhoto("testId", createdAt).setUrl(imageUrl);

        Photo photo1 = new Photo("testId", 1L, 30, 20, "prefix", "suffix");
        Photo photo2 = new Photo("testId2", 2L, 60, 40, "prefix2", "suffix2");

        doReturn(Arrays.asList(photo1, photo2))
                .when(venuePhotoService).getPhotos(anyString());

        when(photoService.createPhoto(
                any(BurgerPhoto.class),
                any(String.class),
                any(String.class),
                any(Integer.class),
                any(Integer.class)
        ))
                .thenReturn(burgerPhoto);

        when(venuePhotoAnalyzerService.isBurger(anyString()))
                .thenReturn(true);

        BurgerPhoto expectedResult = burgerPhoto.setBurger(true);
        BurgerPhoto result = venuePhotoService.getLastPhoto("testId");

        assertEquals(expectedResult, result);
        verify(venuePhotoService).getPhotos("testId");
        verify(photoService).createPhoto(
                any(BurgerPhoto.class),
                any(String.class),
                any(String.class),
                any(Integer.class),
                any(Integer.class)
        );
        verify(venuePhotoAnalyzerService).isBurger(imageUrl);
    }
}