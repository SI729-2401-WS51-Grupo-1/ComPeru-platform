package pe.edu.upc.comperu_platform.profiles.domain.model.queries;

import pe.edu.upc.comperu_platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery<EmailAddress>(EmailAddress emailAddress) {
}