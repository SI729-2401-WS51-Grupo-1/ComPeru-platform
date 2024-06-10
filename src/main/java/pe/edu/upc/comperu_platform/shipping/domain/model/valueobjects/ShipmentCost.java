package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ShipmentCost(double cost) {

    public ShipmentCost {
        if (cost < 0.0) {
            throw new IllegalArgumentException("Shipment cost cannot be negative");
        }
    }
    public ShipmentCost() {
        this(0.0);
    }

}