package pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductId(Long productId) {
    public ProductId{
        if(productId <0){
            throw new IllegalArgumentException("ProductId cannot be negative");
        }
    }

    public ProductId(){
        this(0L);
    }
}
