package pe.edu.upc.comperu_platform.profiles.domain.services;

import pe.edu.upc.comperu_platform.profiles.domain.model.aggregates.Profile;
import pe.edu.upc.comperu_platform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
  Optional<Profile> handle(CreateProfileCommand command);
}