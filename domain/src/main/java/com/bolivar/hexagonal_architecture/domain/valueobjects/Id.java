package com.bolivar.hexagonal_architecture.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Id {

    @NonNull
    Long value;

    private Id(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("ID no valido.");
        }
        this.value = value;
    }

    public static Id of(Long value) {
        return new Id(value);
    }
}
