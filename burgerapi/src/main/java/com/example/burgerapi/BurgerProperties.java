package com.example.burgerapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "burger"
)
public class BurgerProperties {

    private String apiUrl;

    public BurgerProperties() {}

    public BurgerProperties(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public String toString() {
        return "BurgerProperties{" +
                "apiUrl='" + apiUrl + '\'' +
                '}';
    }
}
