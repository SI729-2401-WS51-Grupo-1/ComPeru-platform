package pe.edu.upc.comperu_platform.reviews.domain.services;

import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByProductIdQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByRatingQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetReviewByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewsQuery query);
    Optional<Review> handle(GetAllReviewsByRatingQuery query);
    Optional<Review> handle(GetReviewByIdQuery query);

    List<Review> handle(GetAllReviewsByProductIdQuery query);
}
