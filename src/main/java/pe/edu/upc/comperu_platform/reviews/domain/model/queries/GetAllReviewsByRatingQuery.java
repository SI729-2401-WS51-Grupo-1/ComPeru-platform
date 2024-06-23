package pe.edu.upc.comperu_platform.reviews.domain.model.queries;

import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;

public record GetAllReviewsByRatingQuery(int rating) {
}
