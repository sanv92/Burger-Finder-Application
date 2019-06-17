package com.example.demo.application;

import com.example.burgerapi.BurgerApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VenuePhotoAnalyzerServiceTest {

    @Mock
    private BurgerApi burgerApi;

    private VenuePhotoAnalyzerService venuePhotoAnalyzerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        this.venuePhotoAnalyzerService = new VenuePhotoAnalyzerService(burgerApi);
    }

    @Test
    void isBurger() {
        when(burgerApi.analyzeIsBurger(anyString()))
                .thenReturn(true);

        boolean result = venuePhotoAnalyzerService.isBurger("test-url");

        assertTrue(result);
        verify(burgerApi).analyzeIsBurger("test-url");
    }
}