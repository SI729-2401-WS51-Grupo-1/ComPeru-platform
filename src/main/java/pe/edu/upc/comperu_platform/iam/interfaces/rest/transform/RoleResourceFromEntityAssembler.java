package pe.edu.upc.comperu_platform.iam.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.iam.domain.model.entities.Role;
import pe.edu.upc.comperu_platform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {

    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
