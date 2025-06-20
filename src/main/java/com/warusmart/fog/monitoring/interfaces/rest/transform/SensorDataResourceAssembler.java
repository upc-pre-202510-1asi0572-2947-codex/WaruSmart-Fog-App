package com.warusmart.fog.monitoring.interfaces.rest.transform;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import com.warusmart.fog.monitoring.interfaces.rest.resources.SensorDataResource;

public class SensorDataResourceAssembler {

    public static SensorDataResource toResource(SensorData aggregate) {
        return new SensorDataResource(
                aggregate.getDeviceId().value(),
                aggregate.getTemperature().value(),
                aggregate.getHumidity().value(),
                aggregate.getTimestamp()
        );
    }
}
