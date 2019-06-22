package com.example.foursquareapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(FoursquareProperties.class)
@PropertySource("classpath:foursquareapi.properties")
public class FoursquareAutoConfiguration {

    FoursquareAutoConfiguration() {
    }

    @Configuration
    static class FoursquareApiConfiguration {
        private final FoursquareProperties properties;
        private final RestTemplate restTemplate;
        private final ObjectMapper objectMapper;

        @Autowired
        FoursquareApiConfiguration(
                FoursquareProperties properties,
                RestTemplate restTemplate,
                ObjectMapper objectMapper
        ) {
            this.properties = properties;
            this.restTemplate = restTemplate;
            this.objectMapper = objectMapper;
        }

        @Bean
        @ConditionalOnProperty({"foursquare.client-id", "foursquare.client-secret"})
        public FoursquareApi foursquareApi() {
            return new FoursquareApi(properties, restTemplate, objectMapper);
        }
    }
}
