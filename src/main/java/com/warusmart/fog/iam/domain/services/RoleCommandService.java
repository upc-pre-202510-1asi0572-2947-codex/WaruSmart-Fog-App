package com.warusmart.fog.iam.domain.services;

import com.warusmart.fog.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
