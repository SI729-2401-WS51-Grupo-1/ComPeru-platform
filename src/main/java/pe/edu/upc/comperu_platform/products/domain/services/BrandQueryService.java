package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.queries.GetAllBrandsQuery;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetBrandByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BrandQueryService {
    Optional<Brand> handle(GetBrandByIdQuery query);
    List<Brand> handle(GetAllBrandsQuery query);
}
