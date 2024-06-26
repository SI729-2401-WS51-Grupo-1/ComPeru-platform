package pe.edu.upc.comperu_platform.shipping.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.shipping.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipping.domain.model.queries.GetShipmentByIdQuery;
import pe.edu.upc.comperu_platform.shipping.domain.services.ShipmentQueryService;
import pe.edu.upc.comperu_platform.shipping.infraestructure.persistence.jpa.repositories.ShipmentRepository;

import java.util.Optional;

@Service
public class ShipmentQueryServicesImpl implements ShipmentQueryService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentQueryServicesImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }
    @Override
    public Optional<Shipment> handle(GetShipmentByIdQuery query) {
        return shipmentRepository.findById(query.ShipmentId());
    }
}
