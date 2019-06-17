package com.example.demo.venues.dtos.formatters;

import com.example.demo.domain.model.CityType;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CityTypeFormatter implements Formatter<CityType> {

    private final CityType[] cityTypes;

    public CityTypeFormatter() {
        this.cityTypes = CityType.values();
    }

    @Override
    public String print(CityType cityType, Locale locale) {
        return cityType.getName();
    }

    @Override
    public CityType parse(String text, Locale locale) throws ParseException {
        for (CityType type : cityTypes) {
            if (type.name().equals(text)) {
                return type;
            }
        }

        throw new ParseException("Type not found: " + text, 0);
    }
}
