package com.warusmart.fog.monitoring.interfaces.rest.resources;

import java.time.LocalDateTime;

public record SensorDataResource(
        String deviceId,
        float temperature,
        float humidity,
        float soilMoisture,
        String zone,
        LocalDateTime timestamp
) {}