package com.warusmart.fog.iam.domain.model.aggregates;

import com.warusmart.fog.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@NoArgsConstructor
public class FogIAM extends AuditableAbstractAggregateRoot<FogIAM> {

    @OneToMany(mappedBy = "fogIAM", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyColumn(name = "edge_id")
    private Map<String, Edge> edges = new HashMap<>();

    public Edge registerEdge(String edgeId, String deviceInfo) {
        if (edges.containsKey(edgeId)) {
            throw new IllegalStateException("Edge already registered");
        }

        Edge edge = new Edge(edgeId, deviceInfo, this);
        edges.put(edgeId, edge);
        return edge;
    }

    public Edge getEdge(String edgeId) {
        if (!edges.containsKey(edgeId)) {
            throw new IllegalStateException("Edge not found");
        }
        return edges.get(edgeId);
    }

    public void updatePermissions(String edgeId, Set<String> permissions) {
        Edge edge = getEdge(edgeId);
        edge.getPermissions().clear();
        edge.getPermissions().addAll(permissions);
    }

    public void removeEdge(String edgeId) {
        if (!edges.containsKey(edgeId)) {
            throw new IllegalStateException("Edge not found");
        }
        edges.remove(edgeId);
    }
}