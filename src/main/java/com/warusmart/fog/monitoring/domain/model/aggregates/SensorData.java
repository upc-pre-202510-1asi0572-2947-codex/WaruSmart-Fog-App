package com.warusmart.fog.monitoring.domain.model.aggregates;

import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;
import com.warusmart.fog.monitoring.domain.model.valueobjects.DeviceId;
import com.warusmart.fog.monitoring.domain.model.valueobjects.Humidity;
import com.warusmart.fog.monitoring.domain.model.valueobjects.Temperature;
import com.warusmart.fog.monitoring.domain.model.valueobjects.SoilMoisture;
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
    @AttributeOverride(name = "value", column = @Column(name = "device_id_value"))
    private DeviceId deviceId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "temperature_value"))
    private Temperature temperature;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "humidity_value"))
    private Humidity humidity;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "soil_moisture_value"))
    private SoilMoisture soilMoisture;

    @Column(name = "zone")
    private String zone;

    private LocalDateTime timestamp;

    protected SensorData() {
        // for JPA
    }

    public SensorData(DeviceId deviceId, Temperature temperature, Humidity humidity, SoilMoisture soilMoisture, String zone, LocalDateTime timestamp) {
        this.deviceId = deviceId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.zone = zone;
        this.timestamp = timestamp;
    }

    // Static factory method
    public static SensorData createFrom(CreateSensorDataCommand command) {
        return new SensorData(
                new DeviceId(command.deviceId()),
                new Temperature(command.temperature()),
                new Humidity(command.humidity()),
                new SoilMoisture(command.soilMoisture()),
                command.zone(),
                command.timestamp()
        );
    }
}