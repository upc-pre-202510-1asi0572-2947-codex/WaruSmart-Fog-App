package com.warusmart.fog.iam.interfaces.rest;

import com.warusmart.fog.iam.application.internal.EdgeRegistrationService;
import com.warusmart.fog.iam.domain.model.aggregates.Edge;
import com.warusmart.fog.iam.interfaces.rest.resources.EdgeRegistrationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/edge")
public class EdgeController {

    private final EdgeRegistrationService edgeRegistrationService;

    @Autowired
    public EdgeController(EdgeRegistrationService edgeRegistrationService) {
        this.edgeRegistrationService = edgeRegistrationService;
    }

    @PostMapping("/register")
    public Edge registerEdge(@RequestBody EdgeRegistrationResource edgeRegistrationResource) {
        return edgeRegistrationService.registerEdge(edgeRegistrationResource.edgeId() , edgeRegistrationResource.deviceInfo());
    }

    @GetMapping("/{edgeId}")
    public Edge getEdge(@PathVariable String edgeId) {
        return edgeRegistrationService.getEdge(edgeId);
    }

    @PutMapping("/{edgeId}/permissions")
    public void updatePermissions(@PathVariable String edgeId, @RequestBody Set<String> permissions) {
        edgeRegistrationService.updatePermissions(edgeId, permissions);
    }
}
