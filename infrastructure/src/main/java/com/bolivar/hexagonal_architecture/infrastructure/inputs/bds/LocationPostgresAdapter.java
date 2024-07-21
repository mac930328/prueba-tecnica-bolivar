package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds;

import com.bolivar.hexagonal_architecture.domain.execptions.NotFoundRegisterException;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import com.bolivar.hexagonal_architecture.domain.repositories.LocationRepository;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.LocationEntity;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.mappers.LocationEntityMapper;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.repositories.LocationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class LocationPostgresAdapter implements LocationRepository {

    private final LocationJpaRepository locationJpaRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public List<Location> getAll() {
        return locationJpaRepository.findAll().stream()
                .map(locationEntityMapper::locationEntityToLocation)
                .collect(Collectors.toList());
    }

    @Override
    public Location getById(Long id) {
        return locationJpaRepository.findById(id)
                .map(locationEntityMapper::locationEntityToLocation)
                .orElseThrow(() -> new NotFoundRegisterException(String.format("El registro %s no existe.", id)));
    }

    @Override
    public Location update(Location object) {

        if (!locationJpaRepository.existsById(object.getId())) {
            throw new NotFoundRegisterException(String.format("El registro %s no existe.", object.getId()));
        }

        return locationEntityMapper.locationEntityToLocation(saveOrUpdate(object));
    }

    @Override
    public Location delete(Long id) {

        if (!locationJpaRepository.existsById(id)) {
            throw new NotFoundRegisterException(String.format("El registro %s no existe.", id));
        }

        locationJpaRepository.deleteById(id);
        return Location.builder().id(id).build();
    }

    @Override
    public Location save(Location object) {

        if (object.getId() != null && locationJpaRepository.existsById(object.getId())) {
            throw new NotFoundRegisterException(String.format("El registro %s ya existe.", object.getId()));
        }

        return locationEntityMapper.locationEntityToLocation(saveOrUpdate(object));
    }

    private LocationEntity saveOrUpdate(Location object) {

        LocationEntity savedEntity = null;
        if (object.getId() == null) {
            LocationEntity locationEntityToSave = locationEntityMapper.locationToLocationEntity(object);
            locationEntityToSave.setUpdated(LocalDateTime.now());
            savedEntity = locationJpaRepository.save(locationEntityToSave);
        } else {
            LocationEntity existing = locationJpaRepository.findById(object.getId()).orElse(null);
            if (existing != null) {
                existing.setName(object.getName());
                existing.setType(object.getType());
                existing.setDimension(object.getDimension());
                existing.setUpdated(LocalDateTime.now());
                savedEntity = locationJpaRepository.save(existing);
            } else {
                LocationEntity locationEntityToSave = locationEntityMapper.locationToLocationEntity(object);
                locationEntityToSave.setUpdated(LocalDateTime.now());
                savedEntity = locationJpaRepository.save(locationEntityToSave);
            }
        }

        return savedEntity;
    }
}
