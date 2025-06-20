package com.warusmart.fog.iam.domain.services;

import com.warusmart.fog.iam.domain.model.aggregates.User;
import com.warusmart.fog.iam.domain.model.commands.SignInCommand;
import com.warusmart.fog.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}
