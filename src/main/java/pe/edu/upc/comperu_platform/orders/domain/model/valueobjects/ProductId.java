package pe.edu.upc.comperu_platform.orders.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the product id
 */

@Embeddable
public record ProductId(Long productId) {

    public ProductId {
        if (productId < 0) {
            throw new IllegalArgumentException("Product Id cannot be negative");
        }
    }

    public ProductId() {this(0L);}
}
