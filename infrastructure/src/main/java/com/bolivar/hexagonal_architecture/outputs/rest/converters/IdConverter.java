package com.bolivar.hexagonal_architecture.outputs.rest.converters;

import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdConverter implements Converter<String, Id> {

    @Override
    public Id convert(String source) {
        try {
            Long value = Long.parseLong(source);
            return Id.of(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format: " + source);
        }
    }
}
