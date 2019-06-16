package com.example.demo.config.burgerapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(BurgerProperties.class)
@PropertySource("classpath:burgerapi.properties")
public class BurgerAutoConfiguration {

    BurgerAutoConfiguration() {
    }

    @Configuration
    static class BurgerApiConfiguration {
        private final BurgerProperties properties;
        private final RestTemplate restTemplate;
        private final ObjectMapper objectMapper;

        @Autowired
        BurgerApiConfiguration(
                BurgerProperties properties,
                RestTemplate restTemplate,
                ObjectMapper objectMapper
        ) {
            this.properties = properties;
            this.restTemplate = restTemplate;
            this.objectMapper = objectMapper;
        }

        @Bean
        public BurgerApi burgerApi() {
            return new BurgerApi(properties, restTemplate, objectMapper);
        }
    }
}