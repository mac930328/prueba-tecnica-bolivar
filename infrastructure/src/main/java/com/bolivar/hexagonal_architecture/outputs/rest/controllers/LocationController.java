package com.bolivar.hexagonal_architecture.outputs.rest.controllers;

import com.bolivar.hexagonal_architecture.domain.models.dtos.LocationDto;
import com.bolivar.hexagonal_architecture.domain.services.LocationUseCase;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/locations", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class LocationController extends RestControllerAbstract<LocationDto, Id> {

    @Autowired
    public LocationController(LocationUseCase locationUseCase) {
        super(locationUseCase);
    }
}
