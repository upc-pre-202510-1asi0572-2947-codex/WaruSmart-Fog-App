package com.warusmart.fog.iam.application.internal;

import com.warusmart.fog.iam.domain.model.aggregates.FogIAM;
import com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories.EdgeRepository;
import com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories.FogIAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warusmart.fog.iam.domain.model.aggregates.Edge;

import java.util.Set;
@Service
public class EdgeRegistrationService {

    private final FogIAMService fogIAMService;
    private final EdgeRepository edgeRepository;
    private final FogIAMRepository fogIAMRepository;

    @Autowired
    public EdgeRegistrationService(FogIAMService fogIAMService, EdgeRepository edgeRepository, FogIAMRepository fogIAMRepository) {
        this.fogIAMService = fogIAMService;
        this.edgeRepository = edgeRepository;
        this.fogIAMRepository = fogIAMRepository;
    }

    // Método para registrar un Edge
    public Edge registerEdge(String edgeId, String deviceInfo) {
        if (edgeRepository.existsByEdgeId(edgeId)) {
            throw new IllegalStateException("El Edge con ID " + edgeId + " ya está registrado.");
        }

        FogIAM fogIAM = fogIAMService.createOrGetFogIAM();

        Edge edge = new Edge(edgeId, deviceInfo, fogIAM);

        return edgeRepository.save(edge);
    }

    public Edge getEdge(String edgeId) {
        FogIAM fogIAM = fogIAMRepository.findById(1L).orElseThrow(() -> new IllegalStateException("FogIAM not found"));
        return fogIAM.getEdge(edgeId);
    }

    public void updatePermissions(String edgeId, Set<String> permissions) {
        FogIAM fogIAM = fogIAMRepository.findById(1L).orElseThrow(() -> new IllegalStateException("FogIAM not found"));
        fogIAM.updatePermissions(edgeId, permissions);
    }

    public void removeEdge(String edgeId) {
        FogIAM fogIAM = fogIAMRepository.findById(1L).orElseThrow(() -> new IllegalStateException("FogIAM not found"));
        fogIAM.removeEdge(edgeId);
    }
}