package com.example.demo.domain.service;

import com.example.demo.domain.model.BurgerPhoto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhotoServiceTest {

    private PhotoService photoService;

    @BeforeEach
    void setUp() {
        this.photoService = new PhotoService();
    }

    @Test
    @Description("should create correct photo url")
    void createPhoto() {
        Long createdAt = Instant.now().toEpochMilli();

        BurgerPhoto result = this.photoService.createPhoto(
                new BurgerPhoto("1", createdAt),
                "/prefix/", "/suffix.jpg", 30, 20
        );

        String expectedResult = "/prefix/30x20/suffix.jpg";

        assertEquals(expectedResult, result.getUrl());
    }
}