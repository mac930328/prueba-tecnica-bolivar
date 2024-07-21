package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Information {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
