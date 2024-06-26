package pe.edu.upc.comperu_platform.shipping.domain.services;

import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipping.domain.model.queries.GetShipmentByIdQuery;

import java.util.Optional;

public interface ShipmentQueryService {
    Optional<Shipment> handle(GetShipmentByIdQuery query);
}
