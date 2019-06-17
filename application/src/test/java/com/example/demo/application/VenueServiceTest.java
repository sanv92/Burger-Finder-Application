package com.example.demo.application;

import com.example.demo.domain.model.handling.ResourceNotFoundException;
import com.example.foursquareapi.FoursquareApi;
import com.example.foursquareapi.model.venue.Venue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Description;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VenueServiceTest {

    private FoursquareApi foursquareApi;

    private VenueService venueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        this.foursquareApi = Mockito.mock(FoursquareApi.class, Mockito.RETURNS_DEEP_STUBS);
        this.venueService = new VenueService(foursquareApi);
    }

    @Test
    void getById() {
        when(foursquareApi.venues().findById(anyString()))
                .thenReturn(Optional.of(new Venue()));

        Venue expectedResult = venueService.getById("testId");

        assertEquals(expectedResult, new Venue());
        verify(foursquareApi.venues()).findById("testId");
    }

    @Test
    @Description("should throw exception, if venue is empty")
    void throwExceptionWhenGetByIdAndVenueNotExists() {
        when(foursquareApi.venues().findById(anyString()))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> venueService.getById("test")
        );
        verify(foursquareApi.venues()).findById("test");
    }
}