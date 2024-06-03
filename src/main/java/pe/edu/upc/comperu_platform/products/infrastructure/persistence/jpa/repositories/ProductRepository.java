package pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.EntrepreneurId;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.ProductRatingsMetricSet;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIdAndEntrepreneurId(Long id, Long entrepreneurId);
    List<Product> findByBrandId(Long brandId);

    List<Product> findByEntrepreneurId(Long entrepreneurId);
    List<Product> findByCategoryId(Long categoryId);
    Optional<Product> findByNameContainingIgnoreCase(String searchTerm);
    List<Product> findByAvailabilityTrue();
    List<Product> findByAvailabilityFalse();
    List<Product> findByRatingBetween(ProductRatingsMetricSet rating, ProductRatingsMetricSet rating2) ;

}
