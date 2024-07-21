package com.bolivar.hexagonal_architecture.domain.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LocationDto {

    private Long id;
    private String name;
    private String type;
    private String dimension;
    private LocalDateTime created;
    private LocalDateTime updated;
}
