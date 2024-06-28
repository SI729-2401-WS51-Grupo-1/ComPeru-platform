package pe.edu.upc.comperu_platform.shipment.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.UserId;
import pe.edu.upc.comperu_platform.shipment.domain.model.aggregates.Shipment;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Optional<Shipment> findById(Long shipmentId);
    Optional<Shipment> findByDocumentNumber(String documentNumber);

    Optional<Shipment> findByUserId(UserId userId);

}