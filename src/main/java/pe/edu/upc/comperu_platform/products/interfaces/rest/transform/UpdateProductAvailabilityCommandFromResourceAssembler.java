package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.UpdateProductAvailabilityCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.ModifyAvailabilityProductResource;

public class UpdateProductAvailabilityCommandFromResourceAssembler {
    public static UpdateProductAvailabilityCommand ToCommandFromResource(Long productId, ModifyAvailabilityProductResource resource){
        return new UpdateProductAvailabilityCommand(productId,resource.availability());
    }
}
