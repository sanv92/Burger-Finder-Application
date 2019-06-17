package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BurgerPhoto {

    private String id;
    private Long createdAt;
    private String url;
    private boolean isBurger;

    public BurgerPhoto(String id, Long createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public BurgerPhoto setId(String id) {
        this.id = id;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public BurgerPhoto setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BurgerPhoto setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isBurger() {
        return isBurger;
    }

    public BurgerPhoto setBurger(boolean burger) {
        this.isBurger = burger;
        return this;
    }
}
