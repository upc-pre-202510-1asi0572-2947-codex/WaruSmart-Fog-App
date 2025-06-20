package com.warusmart.fog.monitoring.domain.model.valueobjects;

public record DeviceId(String value) {
    public DeviceId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("DeviceId cannot be null or blank");
        }
    }
}
