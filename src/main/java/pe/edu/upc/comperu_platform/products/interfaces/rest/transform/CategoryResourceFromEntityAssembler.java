package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {

    public static CategoryResource toResourceFromEntity(Category entity){

        return  new CategoryResource(entity.getId(), entity.getName());

    }

}
