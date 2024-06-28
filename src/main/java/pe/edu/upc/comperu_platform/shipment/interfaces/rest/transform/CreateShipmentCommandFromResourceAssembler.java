package pe.edu.upc.comperu_platform.shipment.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.shipment.domain.model.commands.CreateShipmentCommand;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources.CreateShipmentResource;

public class CreateShipmentCommandFromResourceAssembler {
    public static CreateShipmentCommand toCommandFromResource(CreateShipmentResource createShipmentResource) {
        return new CreateShipmentCommand(
                createShipmentResource.firstName(),
                createShipmentResource.lastName(),
                createShipmentResource.street(),
                createShipmentResource.number(),
                createShipmentResource.city(),
                createShipmentResource.postalCode(),
                createShipmentResource.country(),
                createShipmentResource.phoneNumber(),
                createShipmentResource.documentNumber(),
                createShipmentResource.userId()
        );
    }
}