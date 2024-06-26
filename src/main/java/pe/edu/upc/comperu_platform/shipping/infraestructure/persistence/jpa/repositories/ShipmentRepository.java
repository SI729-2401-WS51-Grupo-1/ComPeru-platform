package pe.edu.upc.comperu_platform.shipping.infraestructure.persistence.jpa.repositories;

import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;

import java.util.Optional;

public interface ShipmentRepository {
    Optional<Shipment> findById(Long orderId);
    boolean existsById(Long orderId);
}
