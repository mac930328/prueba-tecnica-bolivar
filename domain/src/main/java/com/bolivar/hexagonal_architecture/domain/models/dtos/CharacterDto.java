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
public class CharacterDto {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Long origin;
    private Long location;
    private String image;
    private LocalDateTime created;
    private LocalDateTime updated;
}
