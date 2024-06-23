package pe.edu.upc.comperu_platform.reviews.domain.model.commands;

import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

public record CreateReviewCommand(User user, String content, int rating) {
}
