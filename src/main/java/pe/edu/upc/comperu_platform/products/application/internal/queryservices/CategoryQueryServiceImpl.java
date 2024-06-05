package pe.edu.upc.comperu_platform.products.application.internal.queryservices;

import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetCategoryByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.CategoryQueryService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.CategoryRepository;

import java.util.Optional;

public class CategoryQueryServiceImpl implements CategoryQueryService {

    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Optional<Category> handle(GetCategoryByIdQuery query) {
        return categoryRepository.findById(query.categoryId());
    }
}
