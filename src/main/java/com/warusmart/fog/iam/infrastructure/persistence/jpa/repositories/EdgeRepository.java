package com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories;

import com.warusmart.fog.iam.domain.model.aggregates.Edge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}
