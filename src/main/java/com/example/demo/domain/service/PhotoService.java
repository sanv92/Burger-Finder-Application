package com.example.demo.domain.service;

import com.example.demo.domain.model.BurgerPhoto;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    public BurgerPhoto createPhoto(BurgerPhoto photo, String prefix, String suffix, Integer width, Integer height) {
        return photo
                .setUrl(createUrl(prefix, suffix, height, width));
    }

    private String createUrl(String prefix, String suffix, Integer height, Integer width) {
        return prefix + width + 'x' + height + suffix;
    }
}
