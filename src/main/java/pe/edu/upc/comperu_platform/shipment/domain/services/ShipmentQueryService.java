package pe.edu.upc.comperu_platform.shipment.domain.services;


import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetAllShipmentsQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByDocumentNumberQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByIdQuery;

import java.util.Optional;
import java.util.List;


public interface ShipmentQueryService {
    Optional<Shipment> handle(GetShipmentByDocumentNumberQuery query);
    Optional<Shipment> handle(GetShipmentByIdQuery query);
    List<Shipment> handle(GetAllShipmentsQuery query);
}
