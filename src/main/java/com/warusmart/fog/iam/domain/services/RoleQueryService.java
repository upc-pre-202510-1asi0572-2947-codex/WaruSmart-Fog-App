package com.warusmart.fog.iam.domain.services;

import com.warusmart.fog.iam.domain.model.entities.Role;
import com.warusmart.fog.iam.domain.model.queries.GetAllRolesQuery;
import com.warusmart.fog.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
