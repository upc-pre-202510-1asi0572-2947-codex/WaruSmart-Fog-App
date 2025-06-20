package com.warusmart.fog.monitoring.application.internal.commandservices;

import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;

public interface CreateSensorDataCommandService {
    void handle(CreateSensorDataCommand command);
}
