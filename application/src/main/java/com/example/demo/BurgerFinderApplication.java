package com.example.demo;

import com.example.burgerapi.BurgerAutoConfiguration;
import com.example.foursquareapi.FoursquareAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ BurgerAutoConfiguration.class, FoursquareAutoConfiguration.class})
@SpringBootApplication
public class BurgerFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgerFinderApplication.class, args);
    }

}
