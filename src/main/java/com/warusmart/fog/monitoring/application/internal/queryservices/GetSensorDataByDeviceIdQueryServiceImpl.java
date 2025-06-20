package com.warusmart.fog.monitoring.application.internal.queryservices;

import com.warusmart.fog.monitoring.domain.model.aggregates.SensorData;
import com.warusmart.fog.monitoring.domain.model.queries.GetSensorDataByDeviceIdQuery;
import com.warusmart.fog.monitoring.infrastructure.persistence.jpa.repositories.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSensorDataByDeviceIdQueryServiceImpl implements GetSensorDataByDeviceIdQueryService {

    private final SensorDataRepository repository;

    public GetSensorDataByDeviceIdQueryServiceImpl(SensorDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SensorData> handle(GetSensorDataByDeviceIdQuery query) {
        return repository.findTop10ByDeviceIdValueOrderByTimestampDesc(query.deviceId());
    }
}
