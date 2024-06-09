package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateBrandCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateBrandResource;

public class CreateBrandCommandFromResourceAssembler {

    public static CreateBrandCommand toCommandFromResource(CreateBrandResource resource){

        return new CreateBrandCommand(resource.name());

    }
}
