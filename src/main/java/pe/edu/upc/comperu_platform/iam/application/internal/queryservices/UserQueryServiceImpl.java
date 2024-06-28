package pe.edu.upc.comperu_platform.iam.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.iam.domain.model.aggregates.User;
import pe.edu.upc.comperu_platform.iam.domain.model.entities.Role;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserRoleByUserIdQuery;
import pe.edu.upc.comperu_platform.iam.domain.services.UserQueryService;
import pe.edu.upc.comperu_platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserQueryService} interface.
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository {@link UserRepository} instance.
     */
    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method is used to handle {@link GetAllUsersQuery} query.
     * @param query {@link GetAllUsersQuery} instance.
     * @return {@link List} of {@link User} instances.
     * @see GetAllUsersQuery
     */
    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    /**
     * This method is used to handle {@link GetUserByIdQuery} query.
     * @param query {@link GetUserByIdQuery} instance.
     * @return {@link Optional} of {@link User} instance.
     * @see GetUserByIdQuery
     */
    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    /**
     * This method is used to handle {@link GetUserByUsernameQuery} query.
     * @param query {@link GetUserByUsernameQuery} instance.
     * @return {@link Optional} of {@link User} instance.
     * @see GetUserByUsernameQuery
     */
    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }

    @Override
    public Optional<Role> handle(GetUserRoleByUserIdQuery query) {
        return userRepository.findById(query.userId())
                .flatMap(user -> user.getRoles().stream().findFirst());

    }
}
