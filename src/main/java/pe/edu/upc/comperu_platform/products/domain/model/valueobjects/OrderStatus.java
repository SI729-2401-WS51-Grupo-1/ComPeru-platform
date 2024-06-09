package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public enum OrderStatus {
    PENDING,
    PROCESSED,
    SHIPPED,
    DELIVERED,
    CANCELLED,

}
