package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Response<T> {

    private Information info;
    private List<T> results;
}
