package pe.edu.upc.comperu_platform.reviews.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewCommandService;
import pe.edu.upc.comperu_platform.reviews.infrastructure.persistence.jpa.repositories.ReviewRepository;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
