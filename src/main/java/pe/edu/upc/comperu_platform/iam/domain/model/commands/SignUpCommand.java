package pe.edu.upc.comperu_platform.iam.domain.model.commands;


import pe.edu.upc.comperu_platform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
