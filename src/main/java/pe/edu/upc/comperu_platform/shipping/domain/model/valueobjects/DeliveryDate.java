package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

import java.time.LocalDateTime;

public record DeliveryDate(LocalDateTime estimatedDelivery) {
    public DeliveryDate() {
        this(LocalDateTime.now());
    }
}