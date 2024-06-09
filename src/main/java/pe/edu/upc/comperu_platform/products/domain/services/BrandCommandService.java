package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateBrandCommand;

public interface BrandCommandService {

    Long handle(CreateBrandCommand command);
}
