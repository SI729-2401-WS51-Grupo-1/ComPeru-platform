package pe.edu.upc.comperu_platform.reviews.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    Optional<Review> findByRating(int rating);
}
