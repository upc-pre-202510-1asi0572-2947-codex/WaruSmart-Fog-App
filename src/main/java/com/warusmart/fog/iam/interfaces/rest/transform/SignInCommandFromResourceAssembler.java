package com.warusmart.fog.iam.interfaces.rest.transform;

import com.warusmart.fog.iam.domain.model.commands.SignInCommand;
import com.warusmart.fog.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
