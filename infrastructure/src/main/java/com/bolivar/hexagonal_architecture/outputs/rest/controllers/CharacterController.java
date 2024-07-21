package com.bolivar.hexagonal_architecture.outputs.rest.controllers;

import com.bolivar.hexagonal_architecture.domain.models.dtos.CharacterDto;
import com.bolivar.hexagonal_architecture.domain.services.CharacterUseCase;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/characters", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CharacterController extends RestControllerAbstract<CharacterDto, Id> {

    @Autowired
    public CharacterController(CharacterUseCase characterUseCase) {
        super(characterUseCase);
    }

}
