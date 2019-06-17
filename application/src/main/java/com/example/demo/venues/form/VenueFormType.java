package com.example.demo.venues.form;

import com.example.demo.domain.model.CityType;

public class VenueFormType {

    private CityType cityName;

    public VenueFormType(CityType cityName) {
        this.cityName = cityName;
    }

    public CityType getCityName() {
        return cityName;
    }

    public void setCityName(CityType cityName) {
        this.cityName = cityName;
    }
}
