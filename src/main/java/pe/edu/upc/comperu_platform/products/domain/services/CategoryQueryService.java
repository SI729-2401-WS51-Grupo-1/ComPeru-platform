package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetCategoryByIdQuery;

import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> handle(GetCategoryByIdQuery query);
}
