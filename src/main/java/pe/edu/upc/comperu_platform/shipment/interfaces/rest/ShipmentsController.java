package pe.edu.upc.comperu_platform.shipment.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetAllShipmentsQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByIdQuery;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentCommandService;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentQueryService;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources.CreateShipmentResource;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources.ShipmentResource;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.transform.CreateShipmentCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.shipment.interfaces.rest.transform.ShipmentResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Shipments Controller.
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Profile entity.
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/shipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Shipments", description = "Shipment Management Endpoints")
public class ShipmentsController {
    private final ShipmentCommandService shipmentCommandService;
    private final ShipmentQueryService shipmentQueryService;

    public ShipmentsController(ShipmentCommandService shipmentCommandService, ShipmentQueryService shipmentQueryService) {
        this.shipmentCommandService = shipmentCommandService;
        this.shipmentQueryService = shipmentQueryService;
    }

    /**
     * Creates a new Shipment
     * @param resource the resource containing the data to create the Shipment
     * @return the created Shipment
     */
    @PostMapping
    public ResponseEntity<ShipmentResource> createShipment(
        @RequestBody CreateShipmentResource resource) {
        var createShipmentCommand = CreateShipmentCommandFromResourceAssembler
            .toCommandFromResource(resource);
        var shipment = shipmentCommandService.handle(createShipmentCommand);
        if (shipment.isEmpty())
            return ResponseEntity.badRequest().build();
        var shipmentResource = ShipmentResourceFromEntityAssembler.toResourceFromEntity(shipment.get());
        return new ResponseEntity<>(shipmentResource, HttpStatus.CREATED);
    }

    /**
     * Gets a Shipment by its id
     * @param shipmentId the id of the Shipment
     * @return the Shipment
     */
    @GetMapping("/{shipmentId}")
    public ResponseEntity<ShipmentResource> getShipmentById(@PathVariable Long shipmentId) {
        var getShipmentByIdQuery = new GetShipmentByIdQuery(shipmentId);
        var shipment = shipmentQueryService.handle(getShipmentByIdQuery);
        if (shipment.isEmpty())
            return ResponseEntity.badRequest().build();
        var shipmentResource = ShipmentResourceFromEntityAssembler.toResourceFromEntity(shipment.get());
        return ResponseEntity.ok(shipmentResource);
    }


    /**
     * Gets all Shipments
     * @return a list of Shipments
     */
    @GetMapping
    public ResponseEntity<List<ShipmentResource>> getAllShipments() {
        var getAllShipmentsQuery = new GetAllShipmentsQuery();
        var shipments = shipmentQueryService.handle(getAllShipmentsQuery);
        var shipmentResources = shipments.stream()
            .map(ShipmentResourceFromEntityAssembler::toResourceFromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(shipmentResources);
    }
}
