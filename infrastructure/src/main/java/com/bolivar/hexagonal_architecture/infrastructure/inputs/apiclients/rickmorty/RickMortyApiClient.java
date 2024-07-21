package com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities.CharacterResponse;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.entities.LocationResponse;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.mappers.CharacterApiClientObjectMapper;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.apiclients.rickmorty.mappers.LocationApiClientObjectMapper;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Location;
import com.bolivar.hexagonal_architecture.domain.repositories.CharacterApiClient;
import com.bolivar.hexagonal_architecture.domain.repositories.LocationApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class RickMortyApiClient implements CharacterApiClient, LocationApiClient {

    public static final String PAGE = "page";

    public final RestClient restClient;
    private final CharacterApiClientObjectMapper characterResponseMapper;
    private final LocationApiClientObjectMapper locationEntityMapper;

    @Value("${rickmorty.url.location}")
    private String locationPath;
    @Value("${rickmorty.url.character}")
    private String characterPath;

    @Override
    public List<Character> fetchCharacterData() {

        List<CharacterResponse> characters = new ArrayList<>();

        getCharacterData(1, characters);

        return characters.stream()
                .flatMap(characterResponse -> characterResponse.getResults().stream())
                .map(characterResponseMapper::characterEntityToCharacter)
                .collect(Collectors.toList());
    }

    private void getCharacterData(Integer page, List<CharacterResponse> characterResponseList) {

        CharacterResponse characterResponse = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(characterPath)
                        .queryParam(PAGE, page)
                        .build())
                .retrieve()
                .body(CharacterResponse.class);

        characterResponseList.add(characterResponse);

        if (characterResponse.getInfo().getNext() != null) {
            getCharacterData(page + 1, characterResponseList);
        }
    }

    @Override
    public List<Location> fetchLocationData() {

        List<LocationResponse> locations = new ArrayList<>();

        getLocationData(1, locations);

        return locations.stream()
                .flatMap(locationResponse -> locationResponse.getResults().stream())
                .map(locationEntityMapper::locationEntityToLocation)
                .collect(Collectors.toList());
    }

    private void getLocationData(Integer page, List<LocationResponse> locationResponseList) {

        LocationResponse locationResponse = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(locationPath)
                        .queryParam(PAGE, page)
                        .build())
                .retrieve()
                .body(LocationResponse.class);

        locationResponseList.add(locationResponse);

        if (locationResponse.getInfo().getNext() != null) {
            getLocationData(page + 1, locationResponseList);
        }
    }
}
