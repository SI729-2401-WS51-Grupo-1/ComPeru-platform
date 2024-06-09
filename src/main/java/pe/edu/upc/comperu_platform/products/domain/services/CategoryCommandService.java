package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateCategoryCommand;

public interface CategoryCommandService {

    Long handle(CreateCategoryCommand command);
}
