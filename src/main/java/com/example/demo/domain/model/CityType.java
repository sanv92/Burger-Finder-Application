package com.example.demo.domain.model;

public enum CityType {
    TALLINN("Tallinn", 9000, 59.4716181, 24.5981614),
    TARTU("Tartu", 3000, 58.3749473, 26.6975258);

    CityType(
            String name,
            int radius,
            double latitude,
            double longitude
    ) {
        this.name = name;
        this.radius = radius;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private final String name;

    private final int radius;

    private final double latitude;

    private final double longitude;

    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
