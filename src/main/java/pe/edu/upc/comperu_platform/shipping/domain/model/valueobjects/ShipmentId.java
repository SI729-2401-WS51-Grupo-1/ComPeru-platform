package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ShipmentId(Long ShipmentId) {

    public ShipmentId {
        if (ShipmentId < 0) {
            throw new IllegalArgumentException("Profile profileId cannot be negative");
        }
    }
    public ShipmentId() {
        this(0L);
    }

    public String shipmentId() {
        return "";
    }
}
