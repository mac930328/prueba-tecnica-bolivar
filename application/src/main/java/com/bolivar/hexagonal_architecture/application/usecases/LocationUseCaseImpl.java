package com.bolivar.hexagonal_architecture.application.usecases;

import com.bolivar.hexagonal_architecture.application.mappers.LocationDtoMapper;
import com.bolivar.hexagonal_architecture.domain.models.dtos.LocationDto;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import com.bolivar.hexagonal_architecture.domain.repositories.LocationRepository;
import com.bolivar.hexagonal_architecture.domain.services.LocationUseCase;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LocationUseCaseImpl implements LocationUseCase {

    private final LocationRepository locationRepository;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public List<LocationDto> getAll() {
        return locationRepository.getAll().stream()
                .map(locationDtoMapper::locationToLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto getById(Id id) {
        Location location = locationRepository.getById(id.getValue());
        return locationDtoMapper.locationToLocationDto(location);
    }

    @Override
    public LocationDto save(LocationDto object) {
        Location location = locationDtoMapper.locationDtoToLocation(object);
        Location locationSaved = locationRepository.save(location);
        return locationDtoMapper.locationToLocationDto(locationSaved);
    }

    @Override
    public LocationDto update(Id id, LocationDto object) {
        Location location = locationDtoMapper.locationDtoToLocation(object);
        location.setId(id.getValue());
        Location locationUpdated = locationRepository.update(location);
        return locationDtoMapper.locationToLocationDto(locationUpdated);
    }

    @Override
    public LocationDto delete(Id id) {
        Location locationDeleted = locationRepository.delete(id.getValue());
        return locationDtoMapper.locationToLocationDto(locationDeleted);
    }
}
