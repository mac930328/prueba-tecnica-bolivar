package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.mappers;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities.CharacterApiClientObject;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacterApiClientObjectMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "species", source = "species"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "origin.id", expression = "java(getIdFromUrl(characterApiClientObject.getLocation().getUrl()))"),
            @Mapping(target = "location.id", expression = "java(getIdFromUrl(locationApiClientObject.getUrl()))"),
            @Mapping(target = "image", source = "image"),
    })
    Character characterEntityToCharacter(CharacterApiClientObject characterEntity);

    @InheritInverseConfiguration
    CharacterApiClientObject characterToCharacterEntity(Character character);

    default Long getIdFromUrl(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        String[] parts = url.split("/");
        Long id = null;
        try {
            id = Long.valueOf(parts[parts.length - 1]);
        } catch (NumberFormatException e) {
            // o lanzar una excepción o manejar el error según sea necesario
        }

        return id;
    }

}
