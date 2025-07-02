package com.warusmart.fog.monitoring.application.internal.scheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warusmart.fog.monitoring.application.internal.commandservices.CreateSensorDataCommandService;
import com.warusmart.fog.monitoring.domain.model.commands.CreateSensorDataCommand;
import com.warusmart.fog.monitoring.interfaces.rest.resources.SensorReadingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EdgeDataCollectorScheduler {

    private static final Logger logger = LoggerFactory.getLogger(EdgeDataCollectorScheduler.class);
    private static final String EDGE_URL = "http://127.0.0.1:5000/sensor"; // <---AJUSTAR SEGÚN LA RED

    private final CreateSensorDataCommandService commandService;
    private final RestTemplate restTemplate;

    public EdgeDataCollectorScheduler(CreateSensorDataCommandService commandService) {
        this.commandService = commandService;
        this.restTemplate = new RestTemplate();
    }

    // Java
    @Scheduled(fixedRate = 15000)
    public void fetchSensorDataFromEdge() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(EDGE_URL, String.class);
            String body = response.getBody();

            if (body != null && body.contains("\"mensaje\"")) {
                logger.info("Mensaje recibido desde el Edge App: {}", body);
                return;
            }

            SensorReadingDTO lectura = new ObjectMapper().readValue(body, SensorReadingDTO.class);

            if (lectura != null && lectura.deviceId() != null) {
                var command = new CreateSensorDataCommand(
                        lectura.deviceId(),
                        lectura.temperature(),
                        lectura.humidity(),
                        lectura.soilMoisture(),
                        lectura.zone(),
                        lectura.timestamp()
                );
                commandService.handle(command);
                logger.info("Dato guardado desde Edge: {}", lectura);
            } else {
                logger.warn("Lectura inválida o sin deviceId");
            }
        } catch (Exception e) {
            logger.error("Error al obtener datos del Edge App", e);
        }
    }
}
