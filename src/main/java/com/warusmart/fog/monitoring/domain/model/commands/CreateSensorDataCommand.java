package com.warusmart.fog.monitoring.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSensorDataCommand(
        String deviceId,
        float temperature,
        float humidity,
        float soilMoisture,
        String zone,
        LocalDateTime timestamp
) {
    public CreateSensorDataCommand {
        if (deviceId == null || deviceId.isBlank()) {
            throw new IllegalArgumentException("DeviceId is required");
        }
        if (zone == null || zone.isBlank()) {
            throw new IllegalArgumentException("Zone is required");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp is required");
        }
    }
}