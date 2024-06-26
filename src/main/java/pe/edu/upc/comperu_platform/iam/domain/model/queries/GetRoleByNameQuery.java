package pe.edu.upc.comperu_platform.iam.domain.model.queries;

import pe.edu.upc.comperu_platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}