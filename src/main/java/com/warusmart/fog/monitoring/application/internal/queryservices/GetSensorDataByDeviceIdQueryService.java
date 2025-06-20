package com.warusmart.fog.monitoring.application.internal.queryservices;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import com.warusmart.fog.monitoring.domain.model.queries.GetSensorDataByDeviceIdQuery;

import java.util.List;

public interface GetSensorDataByDeviceIdQueryService {
    List<SensorData> handle(GetSensorDataByDeviceIdQuery query);
}
