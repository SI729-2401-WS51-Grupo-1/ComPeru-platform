package pe.edu.upc.comperu_platform.profiles.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.profiles.domain.model.aggregates.Profile;
import pe.edu.upc.comperu_platform.profiles.domain.model.queries.GetAllProfilesQuery;
import pe.edu.upc.comperu_platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import pe.edu.upc.comperu_platform.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.edu.upc.comperu_platform.profiles.domain.model.valueobjects.EmailAddress;
import pe.edu.upc.comperu_platform.profiles.domain.services.ProfileQueryService;
import pe.edu.upc.comperu_platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
  private final ProfileRepository profileRepository;

  public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public Optional<Profile> handle(GetProfileByEmailQuery query) {
    return profileRepository.findByEmail((EmailAddress) query.emailAddress());
  }

  public Optional<Profile> handle(GetProfileByIdQuery query) {
    return profileRepository.findById(query.profileId());
  }

  public List<Profile> handle(GetAllProfilesQuery query) {
    return profileRepository.findAll();
  }
}
