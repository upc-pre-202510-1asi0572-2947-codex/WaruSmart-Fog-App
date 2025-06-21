package com.warusmart.fog.iam.application.internal;

import com.warusmart.fog.iam.domain.model.aggregates.FogIAM;
import com.warusmart.fog.iam.infrastructure.persistence.jpa.repositories.FogIAMRepository;
import org.springframework.stereotype.Service;

@Service
public class FogIAMService {
    private final FogIAMRepository fogIAMRepository;

    public FogIAMService(FogIAMRepository fogIAMRepository) {
        this.fogIAMRepository = fogIAMRepository;
    }

    public FogIAM createOrGetFogIAM() {
        return fogIAMRepository.findById(1L)
                .orElseGet(this::createFogIAM);
    }

    private FogIAM createFogIAM() {
        FogIAM fogIAM = new FogIAM();

        fogIAM = fogIAMRepository.save(fogIAM);
        return fogIAM;
    }
}
