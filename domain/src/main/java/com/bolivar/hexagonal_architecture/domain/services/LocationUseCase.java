package com.bolivar.hexagonal_architecture.domain.services;

import com.bolivar.hexagonal_architecture.domain.models.dtos.LocationDto;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;

public interface LocationUseCase extends AppUseCase<LocationDto, Id> {
}
