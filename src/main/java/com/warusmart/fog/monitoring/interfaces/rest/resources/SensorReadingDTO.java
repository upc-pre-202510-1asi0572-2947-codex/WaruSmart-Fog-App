package com.warusmart.fog.monitoring.interfaces.rest.resources;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.warusmart.fog.monitoring.infrastructure.deserializer.TimestampDeserializer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public record SensorReadingDTO(
        String deviceId,
        float temperature,
        float humidity,
        @JsonDeserialize(using = TimestampDeserializer.class)
        LocalDateTime timestamp
) {
}
