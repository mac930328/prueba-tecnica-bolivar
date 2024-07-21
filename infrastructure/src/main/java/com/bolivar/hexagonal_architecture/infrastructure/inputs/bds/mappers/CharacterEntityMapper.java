package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.mappers;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.CharacterEntity;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterEntityMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "species", source = "species"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "origin.id", source = "origin.id"),
            @Mapping(target = "location.id", source = "location.id"),
            @Mapping(target = "image", source = "image"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    Character characterEntityToCharacter(CharacterEntity characterEntity);

    @InheritInverseConfiguration
    CharacterEntity characterToCharacterEntity(Character character);

}
