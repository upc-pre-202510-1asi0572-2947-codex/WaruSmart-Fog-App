package com.warusmart.fog.iam.application.internal;

import com.warusmart.fog.iam.domain.model.aggregates.FogIAM;
import com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories.FogIAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warusmart.fog.iam.domain.model.aggregates.Edge;

import java.util.Set;

@Service
public class EdgeRegistrationService {

    private final FogIAMRepository fogIAMRepository;

    @Autowired
    public EdgeRegistrationService(FogIAMRepository fogIAMRepository) {
        this.fogIAMRepository = fogIAMRepository;
    }

    public Edge registerEdge(String edgeId, String deviceInfo) {
        FogIAM fogIAM = fogIAMRepository.findById(1L).orElseThrow(() -> new IllegalStateException("FogIAM not found"));
        return fogIAM.registerEdge(edgeId, deviceInfo);
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
