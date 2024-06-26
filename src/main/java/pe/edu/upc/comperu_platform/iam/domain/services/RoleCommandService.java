package pe.edu.upc.comperu_platform.iam.domain.services;

import pe.edu.upc.comperu_platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
