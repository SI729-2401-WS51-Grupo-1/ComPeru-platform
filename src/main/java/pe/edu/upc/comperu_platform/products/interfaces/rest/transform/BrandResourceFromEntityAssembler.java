package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.BrandResource;

public class BrandResourceFromEntityAssembler {

    public static BrandResource toResourceFromEntity (Brand entity){
        return new BrandResource(entity.getId(), entity.getName());
    }


}
