package com.warusmart.fog.monitoring.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String timestampStr = parser.getText();

        try {
            // Intenta parsear como LocalDateTime con microsegundos
            return LocalDateTime.parse(timestampStr, FORMATTER);
        } catch (DateTimeParseException e) {
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