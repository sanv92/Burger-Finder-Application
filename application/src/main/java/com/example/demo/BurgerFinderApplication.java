package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.demo",
        "com.example.burgerapi",
        "com.example.foursquareapi"
},
        scanBasePackageClasses = {}
)
public class BurgerFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgerFinderApplication.class, args);
    }

}
