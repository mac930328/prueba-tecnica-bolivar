package com.bolivar.hexagonal_architecture.application.usecases;

import com.bolivar.hexagonal_architecture.application.mappers.CharacterDtoMapper;
import com.bolivar.hexagonal_architecture.domain.execptions.NotFoundRegisterException;
import com.bolivar.hexagonal_architecture.domain.models.dtos.CharacterDto;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import com.bolivar.hexagonal_architecture.domain.repositories.CharacterRepository;
import com.bolivar.hexagonal_architecture.domain.services.CharacterUseCase;
import com.bolivar.hexagonal_architecture.domain.valueobjects.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CharacterUseCaseImpl implements CharacterUseCase {

    private final CharacterRepository characterRepository;
    private final CharacterDtoMapper characterDtoMapper;

    @Override
    public List<CharacterDto> getAll() {
        return characterRepository.getAll().stream()
                .map(characterDtoMapper::characterToCharacterDto)
                .collect(Collectors.toList());
    }

    @Override
    public CharacterDto getById(Id id) {

        Character character = characterRepository.getById(id.getValue());
        return characterDtoMapper.characterToCharacterDto(character);
    }

    @Override
    public CharacterDto save(CharacterDto object) {
        Character character = characterDtoMapper.characterDtoToCharacter(object);
        Character characterSaved = characterRepository.save(character);
        return characterDtoMapper.characterToCharacterDto(characterSaved);
    }

    @Override
    public CharacterDto update(Id id, CharacterDto object) {

        Character character = characterDtoMapper.characterDtoToCharacter(object);
        character.setId(id.getValue());
        Character characterUpdated = characterRepository.update(character);
        return characterDtoMapper.characterToCharacterDto(characterUpdated);
    }

    @Override
    public CharacterDto delete(Id id) {

        Character characterDeleted = characterRepository.delete(id.getValue());
        return characterDtoMapper.characterToCharacterDto(characterDeleted);
    }
}
