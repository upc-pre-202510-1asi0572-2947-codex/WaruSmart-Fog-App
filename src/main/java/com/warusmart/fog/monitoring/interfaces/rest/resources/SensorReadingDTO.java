package com.warusmart.fog.monitoring.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.warusmart.fog.monitoring.infrastructure.deserializer.TimestampDeserializer;

import java.time.LocalDateTime;

public record SensorReadingDTO(
        String deviceId,
        float temperature,
        float humidity,
        @JsonProperty("soil_moisture")
        float soilMoisture,
        String zone,
        @JsonDeserialize(using = TimestampDeserializer.class)
        LocalDateTime timestamp
) {
}