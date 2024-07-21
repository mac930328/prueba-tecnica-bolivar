package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.CustomAttributeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DynamicUpdate
@Entity
@Table(name = "CHARACTERS")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @Column(name = "origin_id")
    @Convert(converter = CustomAttributeConverter.class)
    private LocationEntity origin;
    @Column(name = "location_id")
    @Convert(converter = CustomAttributeConverter.class)
    private LocationEntity location;
    private String image;
    private LocalDateTime created;
    private LocalDateTime updated;
}
