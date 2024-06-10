package pe.edu.upc.comperu_platform.shipping.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.AuditableModel;

/**
 * Represents a delivery route.
 */
@Getter
@Entity
public class DeliveryRoute extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    @NotNull
    private Shipment shipment;

    @NotNull
    private Long routeId;

    @ManyToOne
    @JoinColumn(name = "next_route_id")
    private DeliveryRoute nextRoute;

    public DeliveryRoute(Shipment shipment, Long routeId, DeliveryRoute nextRoute) {
        this.shipment = shipment;
        this.routeId = routeId;
        this.nextRoute = nextRoute;
    }

    public DeliveryRoute() {
        this.routeId = 0L;
        this.nextRoute = null;
    }

    /**
     * Updates the next route in the delivery path.
     * @param nextRoute The next route.
     */
    public void updateNextRoute(DeliveryRoute nextRoute) {
        this.nextRoute = nextRoute;
    }
}