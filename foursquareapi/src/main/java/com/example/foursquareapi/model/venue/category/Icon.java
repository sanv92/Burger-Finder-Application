package com.example.foursquareapi.model.venue.category;

import java.util.Objects;

public class Icon {

    private String prefix;

    private String suffix;

    public Icon() {
    }

    public Icon(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
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
        if (!(o instanceof Icon)) return false;
        Icon icon = (Icon) o;
        return Objects.equals(prefix, icon.prefix) &&
                Objects.equals(suffix, icon.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, suffix);
    }

    @Override
    public String toString() {
        return "Icon{" +
                "prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
