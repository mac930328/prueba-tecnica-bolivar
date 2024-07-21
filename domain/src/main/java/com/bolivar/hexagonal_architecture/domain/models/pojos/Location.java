package com.bolivar.hexagonal_architecture.domain.models.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Location {

    private Long id;
    private String name;
    private String type;
    private String dimension;
    private LocalDateTime created;
    private LocalDateTime updated;
}
