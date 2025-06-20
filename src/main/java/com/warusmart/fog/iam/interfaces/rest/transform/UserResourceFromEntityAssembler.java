package com.warusmart.fog.iam.interfaces.rest.transform;

import com.warusmart.fog.iam.domain.model.aggregates.User;
import com.warusmart.fog.iam.domain.model.entities.Role;
import com.warusmart.fog.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
