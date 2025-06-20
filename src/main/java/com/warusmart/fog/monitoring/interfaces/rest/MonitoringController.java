package com.warusmart.fog.monitoring.interfaces.rest;

import com.warusmart.fog.monitoring.application.internal.queryservices.GetSensorDataByDeviceIdQueryService;
import com.warusmart.fog.monitoring.domain.model.queries.GetSensorDataByDeviceIdQuery;
import com.warusmart.fog.monitoring.interfaces.rest.resources.SensorDataResource;
import com.warusmart.fog.monitoring.interfaces.rest.transform.SensorDataResourceAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fog/api/monitoring")
public class MonitoringController {

    private final GetSensorDataByDeviceIdQueryService queryService;

    public MonitoringController(GetSensorDataByDeviceIdQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{deviceId}/latest")
    public List<SensorDataResource> getLatestSensorData(@PathVariable String deviceId) {
        var query = new GetSensorDataByDeviceIdQuery(deviceId, 10);
        return queryService.handle(query).stream()
                .map(SensorDataResourceAssembler::toResource)
                .collect(Collectors.toList());
    }
}
