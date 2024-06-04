package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateProductCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {

    public static CreateProductCommand toCommandFromResource(CreateProductResource resource){
        return new CreateProductCommand(
                resource.name(),
                resource.description(),
                resource.modelNumber(),
                resource.manufacturerNumber(),
                resource.price(),
                resource.availability(),
                resource.stock(),
                resource.brandId(),
                resource.categoryId(),
                resource.entrepreneurId(),
                resource.imageUrls()
        );
    }

}
