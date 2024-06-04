package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.UpdateProductCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.ProductResource;

public class UpdateProductCommandFromResourceAssembler {

    public static UpdateProductCommand toCommandFromResource(Long productId, ProductResource resource){
        return new UpdateProductCommand(productId,
                resource.name(),
                resource.description(),
                resource.modelNumber(),
                resource.manufacturerNumber(),
                resource.price(),
                resource.availability(),
                resource.stock(),
                resource.brand().Id(),
                resource.category().Id(),
                resource.entrepreneurId(),
                resource.imageUrls()
        );
    }

}
