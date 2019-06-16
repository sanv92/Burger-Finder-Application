package com.example.demo.application;

import com.example.demo.config.burgerapi.BurgerApi;
import org.springframework.stereotype.Service;

@Service
public class VenuePhotoAnalyzerService {

    private BurgerApi burgerApi;

    public VenuePhotoAnalyzerService(BurgerApi burgerApi) {
        this.burgerApi = burgerApi;
    }

    public boolean isBurger(String url) {
        return burgerApi.analyzeIsBurger(url);
    }
}
