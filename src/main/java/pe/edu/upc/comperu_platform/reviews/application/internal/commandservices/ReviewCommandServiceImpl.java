package pe.edu.upc.comperu_platform.reviews.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.comperu_platform.reviews.domain.model.commands.DeleteReviewCommand;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewCommandService;
import pe.edu.upc.comperu_platform.reviews.infrastructure.persistence.jpa.repositories.ReviewRepository;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Long handle(CreateReviewCommand command) {
        var review = new Review(command);
        try {
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return review.getId();
    }

    @Override
    public void handle(DeleteReviewCommand command) {
        if (!reviewRepository.existsById(command.reviewId())) {
            throw new IllegalArgumentException("Review does not exist");
        }
        try {
            reviewRepository.deleteById(command.reviewId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting course: " + e.getMessage());
        }
    }
}
