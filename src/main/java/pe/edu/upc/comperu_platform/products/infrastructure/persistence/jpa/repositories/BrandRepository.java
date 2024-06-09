package pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
