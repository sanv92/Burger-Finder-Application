package com.example.demo.application;

import com.example.burgerapi.BurgerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenuePhotoAnalyzerService {

    private final BurgerApi burgerApi;

    @Autowired
    public VenuePhotoAnalyzerService(BurgerApi burgerApi) {
        this.burgerApi = burgerApi;
    }

    public boolean isBurger(String url) {
        return burgerApi.analyzeIsBurger(url);
    }
}
