package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.commands.*;

import java.util.Optional;

public interface ProductCommandService {

    Long handle(CreateProductCommand command);
    Optional<Product> handle(UpdateProductCommand command);
     void handle(DeleteProductCommand command);
    void handle(AddImageToProductCommand command);
    void handle(RemoveImageFromProductCommand command);
    Optional<Product> handle(UpdateProductAvailabilityCommand command);
    Optional<Product> handle(UpdateProductStockCommand command);

}

