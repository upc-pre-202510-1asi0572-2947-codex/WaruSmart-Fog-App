package com.warusmart.fog.monitoring.infrastructure.persistence.jpa.repositories;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    List<SensorData> findTop10ByDeviceIdValueOrderByTimestampDesc(String deviceId);
}