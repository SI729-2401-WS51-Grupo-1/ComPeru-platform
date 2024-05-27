package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductReviewsMetricSet(Integer totalReviews) {

    public ProductReviewsMetricSet(){
        this(0);
    }

    public ProductReviewsMetricSet{
        if(totalReviews<0){
            throw new IllegalArgumentException("Total reviews cannot be negative");

        }
    }

    public ProductReviewsMetricSet incrementTotalReviews(){
        return new ProductReviewsMetricSet(totalReviews+1);

    }

}
