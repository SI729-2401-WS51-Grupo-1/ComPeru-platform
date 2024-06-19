package pe.edu.upc.comperu_platform.orders.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByorderTitle(String title);
    boolean existsByOrderTitle(String title);
    boolean existsByOrderTitleAndIdIsNot(String title, Long id);
}
