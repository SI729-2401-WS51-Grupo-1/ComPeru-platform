package pe.edu.upc.comperu_platform.orders.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.orders.domain.model.commands.CreateOrderCommand;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.CreateOrderResource;

public class CreateOrderCommandFromResourceAssembler {

    public static CreateOrderCommand toCommandFromResource(CreateOrderResource resource){
        return new CreateOrderCommand(resource.orderTitle(), resource.deliveryMethod(), resource.totalOrder());
    }
}
