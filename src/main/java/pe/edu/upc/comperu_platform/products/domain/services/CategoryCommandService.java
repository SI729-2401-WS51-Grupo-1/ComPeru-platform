package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateCategoryCommand;

import java.util.List;

public interface CategoryCommandService {

    Long handle(CreateCategoryCommand command);
}
