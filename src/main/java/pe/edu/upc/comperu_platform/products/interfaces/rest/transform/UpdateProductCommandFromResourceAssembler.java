package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.UpdateProductCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateProductResource;

public class UpdateProductCommandFromResourceAssembler {

    public static UpdateProductCommand toCommandFromResource(Long productId, CreateProductResource resource){
        return new UpdateProductCommand(productId,
                resource.name(),
                resource.description(),
                resource.modelNumber(),
                resource.manufacturerNumber(),
                resource.price(),
                resource.availability(),
                resource.stock(),
                resource.brandId(),
                resource.categoryId(),
                resource.userId(),
                resource.imageUrls()
        );
    }

}
