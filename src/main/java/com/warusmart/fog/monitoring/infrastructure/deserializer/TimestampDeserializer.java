package com.warusmart.fog.monitoring.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimestampDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String timestampStr = parser.getText();

        try {
            // Intenta parsear como ISO 8601
            Instant instant = Instant.parse(timestampStr);
            return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        } catch (Exception e) {
            // Si falla, intenta parsear como milisegundos
            try {
                long timestampMillis = Long.parseLong(timestampStr);
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampMillis), ZoneOffset.UTC);
            } catch (NumberFormatException ex) {
                throw new IOException("Error parsing timestamp: " + timestampStr, ex);
            }
        }
    }
}