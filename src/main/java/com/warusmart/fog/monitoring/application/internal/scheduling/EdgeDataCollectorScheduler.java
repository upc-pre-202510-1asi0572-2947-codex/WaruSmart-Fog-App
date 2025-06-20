package com.warusmart.fog.monitoring.application.internal.scheduling;

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
    private static final String EDGE_URL = "http://192.168.0.100:8080/sensor"; // <---AJUSTAR SEGÚN LA RED

    private final CreateSensorDataCommandService commandService;
    private final RestTemplate restTemplate;

    public EdgeDataCollectorScheduler(CreateSensorDataCommandService commandService) {
        this.commandService = commandService;
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedRate = 15000) // Cada 15 segundos
    public void fetchSensorDataFromEdge() {
        try {
            ResponseEntity<SensorReadingDTO> response = restTemplate.getForEntity(EDGE_URL, SensorReadingDTO.class);
            SensorReadingDTO dto = response.getBody();

            if (dto != null) {
                var command = new CreateSensorDataCommand(
                        dto.deviceId(),
                        dto.temperature(),
                        dto.humidity(),
                        dto.timestamp()
                );

                commandService.handle(command);
                logger.info("Dato guardado desde Edge: {}", dto);
            } else {
                logger.warn("Respuesta vacía desde el Edge App");
            }
        } catch (Exception e) {
            logger.error("Error al obtener datos del Edge App", e);
        }
    }
}
