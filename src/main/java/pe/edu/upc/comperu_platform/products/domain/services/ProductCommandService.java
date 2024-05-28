package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.commands.*;

public interface ProductCommandService {

    Long handle(CreateProductCommand command);
    void handle(UpdateProductCommand command);
    void handle(DeleteProductCommand command);
    void handle(AddImageToProductCommand command);
    void handle(RemoveImageFromProductCommand command);
    void handle(UpdateProductAvailabilityCommand command);
    void handle(UpdateProductStockCommand command);

}

