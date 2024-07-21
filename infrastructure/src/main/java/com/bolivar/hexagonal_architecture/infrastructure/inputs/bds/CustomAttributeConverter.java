package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds;


import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.LocationEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CustomAttributeConverter implements AttributeConverter<LocationEntity, Long> {

    @Override
    public Long convertToDatabaseColumn(LocationEntity attribute) {
        return attribute != null ? attribute.getId() : null;
    }

    @Override
    public LocationEntity convertToEntityAttribute(Long dbData) {
        return dbData != null ? LocationEntity.builder().id(dbData).build() : null;
    }
}
