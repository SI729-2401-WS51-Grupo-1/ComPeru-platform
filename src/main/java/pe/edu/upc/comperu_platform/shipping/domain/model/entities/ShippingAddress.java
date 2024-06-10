package pe.edu.upc.comperu_platform.shipping.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.Address;

/**
 * Represents a shipping address.
 */
@Getter
@Entity
public class ShippingAddress extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    @NotNull
    private Shipment shipment;

    @OneToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    public ShippingAddress(Shipment shipment, Address address) {
        this.shipment = shipment;
        this.address = address;
    }

    public ShippingAddress() {
        this.address = null;
    }

    /**
     * Updates the shipping address.
     * @param address The address.
     */
    public void updateShippingAddress(Address address) {
        this.address = address;
    }
}