package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the tracking number.
 */
@Embeddable
public record TrackingNumber(Integer number) {
    public TrackingNumber() {
        this(0);
    }

    public TrackingNumber {
        if (number == null) {
            throw new IllegalArgumentException("Tracking number cannot be null");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Tracking number cannot be negative");
        }
    }
}