package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds;

import com.bolivar.hexagonal_architecture.domain.execptions.NotFoundRegisterException;
import com.bolivar.hexagonal_architecture.domain.models.pojos.Character;
import com.bolivar.hexagonal_architecture.domain.repositories.CharacterRepository;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.CharacterEntity;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.mappers.CharacterEntityMapper;
import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.repositories.CharacterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CharacterPostgresAdapter implements CharacterRepository {

    private final CharacterJpaRepository characterJpaRepository;
    private final CharacterEntityMapper characterEntityMapper;

    @Override
    public List<Character> getAll() {
        return characterJpaRepository.findAll().stream()
                .map(characterEntityMapper::characterEntityToCharacter)
                .collect(Collectors.toList());
    }

    @Override
    public Character getById(Long id) {
        return characterJpaRepository.findById(id)
                .map(characterEntityMapper::characterEntityToCharacter)
                .orElseThrow(() -> new NotFoundRegisterException(String.format("El registro %s no existe.", id)));
    }

    @Override
    public Character update(Character object) {

        if (!characterJpaRepository.existsById(object.getId())) {
            throw new NotFoundRegisterException(String.format("El registro %s no existe.", object.getId()));
        }

        return characterEntityMapper.characterEntityToCharacter(saveOrUpdate(object));
    }

    @Override
    public Character delete(Long id) {

        if (!characterJpaRepository.existsById(id)) {
            throw new NotFoundRegisterException(String.format("El registro %s no existe.", id));
        }

        characterJpaRepository.deleteById(id);
        return Character.builder().id(id).build();
    }

    @Override
    public Character save(Character object) {

        if (object.getId() != null && characterJpaRepository.existsById(object.getId())) {
            throw new NotFoundRegisterException(String.format("El registro %s ya existe.", object.getId()));
        }

        return characterEntityMapper.characterEntityToCharacter(saveOrUpdate(object));
    }

    private CharacterEntity saveOrUpdate(Character object) {

        CharacterEntity savedEntity = null;
        if (object.getId() == null) {
            CharacterEntity characterEntityToSave = characterEntityMapper.characterToCharacterEntity(object);
            characterEntityToSave.setCreated(LocalDateTime.now());
            savedEntity = characterJpaRepository.save(characterEntityToSave);
        } else {
            CharacterEntity existing = characterJpaRepository.findById(object.getId()).orElse(null);
            if (existing != null) {
                existing.setName(object.getName());
                existing.setStatus(object.getStatus());
                existing.setSpecies(object.getSpecies());
                existing.setType(object.getType());
                existing.setGender(object.getGender());
                existing.getOrigin().setId(object.getOrigin().getId());
                existing.getLocation().setId(object.getLocation().getId());
                existing.setImage(object.getImage());
                existing.setUpdated(LocalDateTime.now());
                savedEntity = characterJpaRepository.save(existing);
            } else {
                CharacterEntity characterEntityToSave = characterEntityMapper.characterToCharacterEntity(object);
                characterEntityToSave.setCreated(LocalDateTime.now());
                savedEntity = characterJpaRepository.save(characterEntityToSave);
            }
        }

        return savedEntity;
    }
}
