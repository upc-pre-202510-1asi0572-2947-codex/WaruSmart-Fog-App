package com.warusmart.fog.monitoring.interfaces.rest.resources;

import java.time.LocalDateTime;

public record SensorReadingDTO(
        String deviceId,
        float temperature,
        float humidity,
        LocalDateTime timestamp
) {}
