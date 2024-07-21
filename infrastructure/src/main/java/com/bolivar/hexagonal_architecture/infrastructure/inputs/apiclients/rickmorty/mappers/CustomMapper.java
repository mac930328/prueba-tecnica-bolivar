package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.mappers;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

@Component
public class CustomMapper {

    Long getIdFromUrl(String url) {
        return Arrays.stream(url.split("/"))
                .min(Comparator.reverseOrder())
                .map(Long::valueOf)
                .orElse(null);
    }
}
