package com.bolivar.hexagonal_architecture.domain.repositories;

import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;

import java.util.List;

public interface LocationApiClient {

    List<Location> fetchLocationData();
}
