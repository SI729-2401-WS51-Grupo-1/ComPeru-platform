package pe.edu.upc.comperu_platform.shipment.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.shipment.domain.model.commands.CreateShipmentCommand;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByDocumentNumberQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByIdQuery;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentCommandService;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentQueryService;

/**
 * Service Facade for the Shipment context.
 *
 * <p>
 * It is used by the other contexts to interact with the Profile context.
 * It is implemented as part of an anti-corruption layer (ACL) to be consumed by other contexts.
 * </p>
 *
 */
@Service
public class ShipmentsContextFacade {
    private final ShipmentCommandService shipmentCommandService;
    private final ShipmentQueryService shipmentQueryService;

    public ShipmentsContextFacade(ShipmentCommandService shipmentCommandService, ShipmentQueryService shipmentQueryService) {
        this.shipmentCommandService = shipmentCommandService;
        this.shipmentQueryService = shipmentQueryService;
    }

    /**
     * Creates a new Shipment
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param street the street address
     * @param number the number
     * @param city the city
     * @param postalCode the postal code
     * @param country the country
     * @param phoneNumber the phone number
     * @param documentNumber the document number
     * @return the shipment id
     */
    public Long createShipment(String firstName, String lastName, String street, String number, String city, String postalCode,
                               String country, String phoneNumber, String documentNumber) {

        var createShipmentCommand = new CreateShipmentCommand(firstName, lastName, street, number, city,
                postalCode, country, phoneNumber, documentNumber);
        var shipment = shipmentCommandService.handle(createShipmentCommand);
        if (shipment.isEmpty())
            return 0L;
        return shipment.get().getId();
    }


    /**
     * Fetches the shipment id by document number
     *
     * @param documentNumber the document number
     * @return the shipment id
     */
    public Long fetchShipmentIdByDocumentNumber(String documentNumber) {
        var getShipmentByDocumentNumberQuery = new GetShipmentByDocumentNumberQuery(documentNumber);
        var shipment = shipmentQueryService.handle(getShipmentByDocumentNumberQuery);
        if (shipment.isEmpty())
            return 0L;
        return shipment.get().getId();
    }


}
