package com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories;

import com.warusmart.fog.iam.domain.model.aggregates.FogIAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FogIAMRepository extends JpaRepository<FogIAM, Long> {
}
