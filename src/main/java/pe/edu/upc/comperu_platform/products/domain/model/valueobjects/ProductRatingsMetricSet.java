package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductRatingsMetricSet(double averageRating) {

    public ProductRatingsMetricSet {
        if (averageRating < 0 || averageRating > 5) {
            throw new IllegalArgumentException("Average rating must be between 0 and 5");
        }
    }

    public ProductRatingsMetricSet() {
        this(0.0);
    }

}
