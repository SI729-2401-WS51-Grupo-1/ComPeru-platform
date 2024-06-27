package pe.edu.upc.comperu_platform.shipment.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipment.domain.model.commands.CreateShipmentCommand;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentCommandService;
import pe.edu.upc.comperu_platform.shipment.infraestructure.persistence.jpa.repositories.ShipmentRepository;

import java.util.Optional;

@Service
public class ShipmentCommandServiceImpl implements ShipmentCommandService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentCommandServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Optional<Shipment> handle(CreateShipmentCommand command) {
        shipmentRepository.findByDocumentNumber(command.documentNumber()).map(shipment -> {
            throw new IllegalArgumentException("Shipment with document number " + command.documentNumber() + " already exists");
        });

        var shipment = new Shipment(command);
        shipmentRepository.save(shipment);
        return Optional.of(shipment);
    }
}