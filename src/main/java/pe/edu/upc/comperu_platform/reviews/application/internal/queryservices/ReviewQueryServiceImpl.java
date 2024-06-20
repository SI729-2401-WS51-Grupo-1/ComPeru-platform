package pe.edu.upc.comperu_platform.reviews.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByRatingQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewQueryService;
import pe.edu.upc.comperu_platform.reviews.infrastructure.persistence.jpa.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> handle(GetAllReviewsQuery query) {
        return List.of();
    }

    @Override
    public Optional<Review> handle(GetAllReviewsByRatingQuery query) {
        return Optional.empty();
    }
}
