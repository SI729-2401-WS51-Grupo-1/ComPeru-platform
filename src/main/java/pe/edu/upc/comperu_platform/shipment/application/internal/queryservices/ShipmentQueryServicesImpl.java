package pe.edu.upc.comperu_platform.shipment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.UserId;
import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetAllShipmentsQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByDocumentNumberQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByIdQuery;
import pe.edu.upc.comperu_platform.shipment.domain.model.queries.GetShipmentByUserIdQuery;
import pe.edu.upc.comperu_platform.shipment.domain.services.ShipmentQueryService;
import pe.edu.upc.comperu_platform.shipment.infrastructure.persistence.jpa.repository.ShipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentQueryServicesImpl implements ShipmentQueryService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentQueryServicesImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Optional<Shipment> handle(GetShipmentByDocumentNumberQuery query) {
        return shipmentRepository.findByDocumentNumber(query.documentNumber());
    }

    @Override
    public Optional<Shipment> handle(GetShipmentByIdQuery query) {
        return shipmentRepository.findById(query.shipmentId());
    }

    @Override
    public List<Shipment> handle(GetAllShipmentsQuery query) {
        return shipmentRepository.findAll();
    }

    @Override
    public Optional<Shipment> handle(GetShipmentByUserIdQuery query) {
        return shipmentRepository.findByUserId(new UserId(query.userId()));
    }
}
