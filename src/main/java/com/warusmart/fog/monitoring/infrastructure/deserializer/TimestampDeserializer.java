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
            // Try parsing the timestamp as a raw long (milliseconds)
            long timestampMillis = Long.parseLong(timestampStr);
            // Convert milliseconds to LocalDateTime (UTC)
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampMillis), ZoneOffset.UTC);
        } catch (Exception e) {
            throw new IOException("Error parsing timestamp: " + timestampStr, e);
        }
    }
}
