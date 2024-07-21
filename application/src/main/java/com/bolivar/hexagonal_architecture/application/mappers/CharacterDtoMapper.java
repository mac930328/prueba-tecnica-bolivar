package com.bolivar.hexagonal_architecture.application.mappers;

import com.bolivar.hexagonal_architecture.domain.models.dtos.CharacterDto;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterDtoMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "species", source = "species"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "origin", source = "origin.id"),
            @Mapping(target = "location", source = "location.id"),
            @Mapping(target = "image", source = "image"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    CharacterDto characterToCharacterDto(Character character);

    @InheritInverseConfiguration
    Character characterDtoToCharacter(CharacterDto characterDto);

}
