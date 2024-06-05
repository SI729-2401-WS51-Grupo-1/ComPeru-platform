package pe.edu.upc.comperu_platform.products.application.internal.commandservices;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateCategoryCommand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.services.CategoryCommandService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.CategoryRepository;

public class CategoryCommandServiceImpl implements CategoryCommandService {

   private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Long handle(CreateCategoryCommand command) {
        Category category = new Category(command.name());
        categoryRepository.save(category);
        return category.getId();
    }
}
