package com.example.foursquareapi.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    private String id;
    private Long createdAt;
    private Integer width;
    private Integer height;
    private String prefix;
    private String suffix;

    public Photo() {
    }

    public Photo(String id, Long createdAt, Integer width, Integer height, String prefix, String suffix) {
        this.id = id;
        this.createdAt = createdAt;
        this.width = width;
        this.height = height;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) &&
                Objects.equals(createdAt, photo.createdAt) &&
                Objects.equals(width, photo.width) &&
                Objects.equals(height, photo.height) &&
                Objects.equals(prefix, photo.prefix) &&
                Objects.equals(suffix, photo.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, width, height, prefix, suffix);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", width=" + width +
                ", height=" + height +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
