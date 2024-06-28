package pe.edu.upc.comperu_platform.iam.domain.services;

import pe.edu.upc.comperu_platform.iam.domain.model.aggregates.User;
import pe.edu.upc.comperu_platform.iam.domain.model.entities.Role;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.edu.upc.comperu_platform.iam.domain.model.queries.GetUserRoleByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

    Optional<Role> handle(GetUserRoleByUserIdQuery query);

}
