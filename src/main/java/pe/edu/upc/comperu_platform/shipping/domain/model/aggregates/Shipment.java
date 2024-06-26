package pe.edu.upc.comperu_platform.shipping.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.*;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
public class Shipment extends AuditableAbstractAggregateRoot<Shipment> {

    @Embedded
    private ShippingMethod shippingMethod;

    @Embedded
    private ShipmentCost shippingCost;

    @Embedded
    private PackageWeight packageWeight;

    @Embedded
    private DeliveryDate deliveryDate;

    public Shipment() {
        this.shippingCost = new ShipmentCost();
        this.deliveryDate = new DeliveryDate();
        this.packageWeight = new PackageWeight();
    }

    public Shipment( ShippingMethod shippingMethod, ShipmentCost shippingCost, PackageWeight packageWeight, DeliveryDate deliveryDate) {
        this.shippingMethod = shippingMethod;
        this.shippingCost = shippingCost;
        this.packageWeight = packageWeight;
        this.deliveryDate = deliveryDate;
    }


}