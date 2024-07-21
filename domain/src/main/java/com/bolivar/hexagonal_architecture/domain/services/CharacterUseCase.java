package com.bolivar.hexagonal_architecture.domain.services;

import com.bolivar.hexagonal_architecture.domain.models.dtos.CharacterDto;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;

public interface CharacterUseCase extends AppUseCase<CharacterDto, Id> {
}
