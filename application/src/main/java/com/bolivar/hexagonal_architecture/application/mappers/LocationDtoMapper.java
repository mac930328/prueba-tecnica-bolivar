package com.bolivar.hexagonal_architecture.application.mappers;

import com.bolivar.hexagonal_architecture.domain.models.dtos.LocationDto;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationDtoMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "dimension", source = "dimension"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    LocationDto locationToLocationDto(Location location);

    @InheritInverseConfiguration
    Location locationDtoToLocation(LocationDto locationDto);

}
