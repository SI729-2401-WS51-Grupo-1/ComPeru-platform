package pe.edu.upc.comperu_platform.shipment.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources.ShipmentResource;

public class ShipmentResourceFromEntityAssembler {
    public static ShipmentResource toResourceFromEntity(Shipment shipment) {
        return new ShipmentResource (
                shipment.getId(),
                shipment.getFullName(),
                shipment.getCityAddress(),
                shipment.getPhoneNumber(),
                shipment.getDocumentNumber()
        );
    }
}
