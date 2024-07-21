package com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.repositories;

import com.bolivar.hexagonal_architecture.infrastructure.inputs.bds.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<LocationEntity, Long> {
}
