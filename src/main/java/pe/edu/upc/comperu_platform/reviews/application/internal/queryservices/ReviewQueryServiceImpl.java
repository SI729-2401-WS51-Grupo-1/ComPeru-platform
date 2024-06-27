package pe.edu.upc.comperu_platform.reviews.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByProductIdQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByRatingQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetReviewByIdQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.ProductId;
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
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> handle(GetAllReviewsByRatingQuery query) {
        return reviewRepository.findByRating(query.rating());
    }

    @Override
    public Optional<Review> handle(GetReviewByIdQuery query) {
        return reviewRepository.findById(query.reviewId());
    }

    @Override
    public List<Review> handle(GetAllReviewsByProductIdQuery query) {
        ProductId productId = new ProductId(query.productId());
        return reviewRepository.findByProductId(productId);
    }
}
