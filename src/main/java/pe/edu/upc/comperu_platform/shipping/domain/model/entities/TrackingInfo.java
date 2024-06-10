package pe.edu.upc.comperu_platform.shipping.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShippingProvider;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.TrackingNumber;

/**
 * Represents tracking information.
 */
@Getter
@Entity
public class TrackingInfo extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    @NotNull
    private Shipment shipment;

    @NotNull
    private TrackingNumber trackingNumber;

    @NotNull
    private ShippingProvider carrier;

    public TrackingInfo(Shipment shipment, TrackingNumber trackingNumber, ShippingProvider carrier) {
        this.shipment = shipment;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
    }

    public TrackingInfo() {
        this.trackingNumber = new TrackingNumber();
        this.carrier = new ShippingProvider(carrier.name(), carrier.method()); // Error: incompatible types: ShippingProvider[] cannot be converted to ShippingProvider
    }

    /**
     * Updates the tracking information.
     * @param shipment The shipment.
     * @param trackingNumber The tracking number.
     * @param carrier The carrier.
     */
    public void updateTrackingInfo(Shipment shipment, TrackingNumber trackingNumber, ShippingProvider carrier) {
        this.shipment = shipment;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
    }
}