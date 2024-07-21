package com.bolivar.hexagonal_architecture.application.usecases;

import com.bolivar.hexagonal_architecture.domain.repositories.CharacterApiClient;
import com.bolivar.hexagonal_architecture.domain.repositories.CharacterRepository;
import com.bolivar.hexagonal_architecture.domain.repositories.LocationApiClient;
import com.bolivar.hexagonal_architecture.domain.repositories.LocationRepository;
import com.bolivar.hexagonal_architecture.domain.services.SyncDataUseCase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SyncDataUseCaseImpl implements SyncDataUseCase {

    private final CharacterRepository characterRepository;
    private final LocationRepository locationRepository;
    private final CharacterApiClient characterApiClient;
    private final LocationApiClient locationApiClient;


    @Override
    public void syncLocationsData() {
        locationApiClient.fetchLocationData().forEach(location -> locationRepository.save(location));
    }

    @Override
    public void syncCharactersData(){
        characterApiClient.fetchCharacterData().forEach(character -> characterRepository.save(character));
    }

    @Transactional
    @PostConstruct
    public void init() {
        syncLocationsData();
        syncCharactersData();
    }
}
