package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.AddImageToProductCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.AddImageToProductResource;

public class AddImageToProductCommandFromResourceAssembler {

    public static AddImageToProductCommand ToCommandFromResource(Long productId,AddImageToProductResource resource){
        return new AddImageToProductCommand(productId, resource.imgUrl());
    }

}
