package pe.edu.upc.comperu_platform.shipping.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipping.domain.model.commands.CreateShipmentCommand;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.*;
import pe.edu.upc.comperu_platform.shipping.infraestructure.persistence.jpa.repositories.ShipmentRepository;

import java.util.Optional;

@Service
public class ShipmentCommandServiceImpl {
    private final ShipmentRepository shipmentRepository;

    public ShipmentCommandServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Optional<Shipment> handle(CreateShipmentCommand command) {
        if(shipmentRepository.existsById(command.TrackingNumber())) {
            throw new IllegalArgumentException("Shipment already exist with same values");
        }
        // Crear los Value Objects
        DeliveryDate shipmentDate = new DeliveryDate(command.shipmentDate());
        ShipmentCost shipmentCost = new ShipmentCost(command.shipmentCost());
        TrackingNumber trackingNumber = new TrackingNumber(Math.toIntExact(command.TrackingNumber()));
        PackageWeight packageWeight = new PackageWeight(command.packageWeight());
        ShippingAddress address = new ShippingAddress(command.address());
        // Crear una nueva instancia de Shipment
        var shipment = new Shipment(shipmentDate, shipmentCost, trackingNumber, packageWeight, address,);

        return Optional.of(shipment);
    }
}