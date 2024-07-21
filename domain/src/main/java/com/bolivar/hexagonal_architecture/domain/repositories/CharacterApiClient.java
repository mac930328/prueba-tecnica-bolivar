package com.bolivar.hexagonal_architecture.domain.repositories;

import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;

import java.util.List;

public interface CharacterApiClient {

    List<Character> fetchCharacterData();
}
