package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.mappers;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.LocationEntity;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationEntityMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "dimension", source = "dimension"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    Location locationEntityToLocation(LocationEntity locationEntity);

    @InheritInverseConfiguration
    LocationEntity locationToLocationEntity(Location location);

}
