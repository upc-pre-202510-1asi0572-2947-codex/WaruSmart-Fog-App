package com.warusmart.fog.monitoring.domain.model.aggregates;

import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;
import com.warusmart.fog.monitoring.domain.model.valueobjects.DeviceId;
import com.warusmart.fog.monitoring.domain.model.valueobjects.Humidity;
import com.warusmart.fog.monitoring.domain.model.valueobjects.Temperature;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DeviceId deviceId;

    @Embedded
    private Temperature temperature;

    @Embedded
    private Humidity humidity;

    private LocalDateTime timestamp;

    protected SensorData() {
        // for JPA
    }

    public SensorData(DeviceId deviceId, Temperature temperature, Humidity humidity, LocalDateTime timestamp) {
        this.deviceId = deviceId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    // Static factory method
    public static SensorData createFrom(CreateSensorDataCommand command) {
        return new SensorData(
                new DeviceId(command.deviceId()),
                new Temperature(command.temperature()),
                new Humidity(command.humidity()),
                command.timestamp()
        );
    }
}
