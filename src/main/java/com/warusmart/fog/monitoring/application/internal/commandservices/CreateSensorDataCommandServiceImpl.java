package com.warusmart.fog.monitoring.application.internal.commandservices;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;
import com.warusmart.fog.monitoring.infrastructure.persistence.jpa.repositories.SensorDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSensorDataCommandServiceImpl implements CreateSensorDataCommandService {

    private final SensorDataRepository repository;

    public CreateSensorDataCommandServiceImpl(SensorDataRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void handle(CreateSensorDataCommand command) {
        SensorData sensorData = SensorData.createFrom(command);
        repository.save(sensorData);
    }
}
