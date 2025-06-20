package com.warusmart.fog.monitoring.domain.model.queries;

public record GetSensorDataByDeviceIdQuery(
        String deviceId,
        int limit
) {
    public GetSensorDataByDeviceIdQuery {
        if (deviceId == null || deviceId.isBlank()) {
            throw new IllegalArgumentException("DeviceId is required");
        }
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than zero");
        }
    }
}
