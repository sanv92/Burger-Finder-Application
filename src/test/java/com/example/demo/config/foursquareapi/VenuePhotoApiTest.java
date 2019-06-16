package com.example.demo.config.foursquareapi;

import com.example.demo.config.foursquareapi.model.photo.Photo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class VenuePhotoApiTest {

    @Test
    void findByIdDesc() {
        final VenuePhotoApi venuePhotoApi = spy(VenuePhotoApi.class);

        Photo photo1 = createPhoto(1, 0);
        Photo photo2 = createPhoto(2, 1);
        Photo photo3 = createPhoto(3, 2);
        List<Photo> photos = Arrays.asList(photo1, photo2, photo3);

        doReturn(photos).when(venuePhotoApi).findById(anyString());

        List<Photo> expectedResult = Arrays.asList(photo1, photo2, photo3);
        List<Photo> result = venuePhotoApi.findById("1", Sort.Direction.DESC);

        Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    void findByIdAsc() {
        final VenuePhotoApi venuePhotoApi = spy(VenuePhotoApi.class);

        Photo photo1 = createPhoto(1, 0);
        Photo photo2 = createPhoto(2, 1);
        Photo photo3 = createPhoto(3, 2);
        List<Photo> photos = Arrays.asList(photo1, photo2, photo3);

        doReturn(photos).when(venuePhotoApi).findById(anyString());

        List<Photo> expectedResult = Arrays.asList(photo3, photo2, photo1);
        List<Photo> result = venuePhotoApi.findById("1", Sort.Direction.ASC);

        Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    public static Photo createPhoto(int id, int minusDays) {
        Long createdAt = Instant.now().minus(Duration.ofDays(minusDays)).toEpochMilli();

        return new Photo(String.valueOf(id), createdAt, 1, 1, "", "");
    }
}