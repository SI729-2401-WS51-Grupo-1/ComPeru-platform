package pe.edu.upc.comperu_platform.shipping.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShipmentCost;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.Address;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

/**
 * Represents a shipping order.
 */
@Getter
@Entity
public class ShippingOrder extends AuditableModel {
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
    private ShippingAddress shippingAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @NotNull
    private ShipmentCost shipmentCost;

    public ShippingOrder(Shipment shipment, ShippingAddress shippingAddress, User user, ShipmentCost shipmentCost) {
        this.shipment = shipment;
        this.shippingAddress = shippingAddress;
        this.user = user;
        this.shipmentCost = shipmentCost;
    }

    public ShippingOrder() {
        this.shippingAddress = null;
        this.user = null;
        this.shipmentCost = new ShipmentCost();
    }

    /**
     * Updates the shipping order.
     * @param shipment The shipment.
     * @param shippingAddress The shipping address.
     * @param user The user.
     * @param shipmentCost The shipment cost.
     */
    public void updateShippingOrder(Shipment shipment, ShippingAddress shippingAddress, User user, ShipmentCost shipmentCost) {
        this.shipment = shipment;
        this.shippingAddress = shippingAddress;
        this.user = user;
        this.shipmentCost = shipmentCost;
    }
}