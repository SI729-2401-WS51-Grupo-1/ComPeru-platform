package pe.edu.upc.comperu_platform.shipping.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShipmentId;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShippingProvider;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShippingMethod;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShipmentCost;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.PackageWeight;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Represents a shipment.
 * The shipment is an aggregate root.
 */
@Entity
public class Shipment extends AuditableAbstractAggregateRoot<Shipment> {

    @Getter
    @Embedded
    @Column(name = "shipment_id")
    private final ShipmentId shipmentId;

    @Embedded
    private ShippingProvider shippingProvider;

    @Embedded
    private ShippingMethod shippingMethod;

    @Embedded
    private ShipmentCost shippingCost;

    @Embedded
    private PackageWeight packageWeight;

    public Shipment() {
        this.shipmentId = new ShipmentId();
            this.shippingCost = new ShipmentCost();
        this.packageWeight = new PackageWeight();
    }

    public Shipment(ShippingProvider shippingProvider, ShippingMethod shippingMethod) {
        this();
        this.shippingProvider = shippingProvider;
        this.shippingMethod = shippingMethod;
    }

    public String getShipmentId() {
        return this.shipmentId.shipmentId();
    }

    public ShippingProvider getShippingProvider() {
        return this.shippingProvider;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public ShipmentCost getShippingCost() {
        return this.shippingCost;
    }

    public PackageWeight getPackageWeight() {
        return this.packageWeight;
    }
}