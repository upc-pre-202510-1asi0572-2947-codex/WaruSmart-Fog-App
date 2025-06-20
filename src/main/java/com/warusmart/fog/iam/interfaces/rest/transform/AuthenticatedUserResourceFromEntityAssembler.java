package com.warusmart.fog.iam.interfaces.rest.transform;

import com.warusmart.fog.iam.domain.model.aggregates.User;
import com.warusmart.fog.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
