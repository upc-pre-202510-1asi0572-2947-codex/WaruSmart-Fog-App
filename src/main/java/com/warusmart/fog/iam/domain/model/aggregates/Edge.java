package com.warusmart.fog.iam.domain.model.aggregates;

import com.warusmart.fog.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Edge extends AuditableAbstractAggregateRoot<Edge> {

    @Id
    @Column(name = "edge_id")
    private String edgeId;

    private String deviceInfo;

    @ElementCollection
    @CollectionTable(name = "edge_permissions", joinColumns = @JoinColumn(name = "edge_id"))
    @Column(name = "permission")
    private Set<String> permissions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "fog_iam_id")
    private FogIAM fogIAM;

    public Edge(String edgeId, String deviceInfo, FogIAM fogIAM) {
        this.edgeId = edgeId;
        this.deviceInfo = deviceInfo;
        this.fogIAM = fogIAM;
    }
}