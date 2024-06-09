package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.commands.UpdateProductStockCommand;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.UpdateStockProductResource;

public class UpdateProductStockCommandFromResourceAssembler {

    public static UpdateProductStockCommand ToCommandFromResource(Long productId,UpdateStockProductResource resource){
        return new UpdateProductStockCommand(productId, resource.stock());
    }


}
