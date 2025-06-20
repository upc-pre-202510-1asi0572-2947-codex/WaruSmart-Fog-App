package com.warusmart.fog.monitoring.domain.services;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;

public interface SensorDataService {
    SensorData createFrom(CreateSensorDataCommand command);
}
