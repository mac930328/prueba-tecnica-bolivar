package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities;

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
public class CharacterApiClientObject {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationApiClientObject origen;
    private LocationApiClientObject location;
    private String image;
    private List<String> episode;
    private String url;
    private LocalDateTime created;
}
