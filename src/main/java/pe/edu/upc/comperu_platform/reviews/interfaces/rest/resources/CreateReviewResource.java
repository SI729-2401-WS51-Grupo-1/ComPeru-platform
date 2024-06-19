package pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources;

import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

public record CreateReviewResource(User user, String content, Rating rating) {
}
