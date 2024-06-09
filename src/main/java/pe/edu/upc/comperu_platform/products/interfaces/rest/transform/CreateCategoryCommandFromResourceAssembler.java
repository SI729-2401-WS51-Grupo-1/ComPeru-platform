package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateCategoryCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {

    public static  CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource){
        return new CreateCategoryCommand(resource.name());
    }

}
