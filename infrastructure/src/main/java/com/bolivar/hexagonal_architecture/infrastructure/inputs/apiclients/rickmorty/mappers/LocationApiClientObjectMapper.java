package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.mappers;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities.LocationApiClientObject;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationApiClientObjectMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "dimension", source = "dimension"),
    })
    Location locationEntityToLocation(LocationApiClientObject locationEntity);

    @InheritInverseConfiguration
    LocationApiClientObject locationToLocationEntity(Location location);

}
