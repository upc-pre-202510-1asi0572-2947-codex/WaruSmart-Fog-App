package com.warusmart.fog.iam.interfaces.rest.transform;

import com.warusmart.fog.iam.domain.model.entities.Role;
import com.warusmart.fog.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
