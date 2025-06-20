package com.warusmart.fog.monitoring.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSensorDataCommand(
        String deviceId,
        float temperature,
        float humidity,
        LocalDateTime timestamp
) {
    public CreateSensorDataCommand {
        if (deviceId == null || deviceId.isBlank()) {
            throw new IllegalArgumentException("DeviceId is required");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp is required");
        }
    }
}
