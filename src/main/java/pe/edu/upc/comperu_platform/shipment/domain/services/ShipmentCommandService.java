package pe.edu.upc.comperu_platform.shipment.domain.services;

import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipment.domain.model.commands.CreateShipmentCommand;

import java.util.Optional;

public interface ShipmentCommandService {
    Optional<Shipment> handle(CreateShipmentCommand command);
}
