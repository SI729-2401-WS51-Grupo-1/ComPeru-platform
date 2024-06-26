package pe.edu.upc.comperu_platform.orders.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.orders.domain.model.commands.UpdateOrderCommand;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.UpdateOrderResource;

public class UpdateOrderCommandFromResourceAssembler {

    public static UpdateOrderCommand toCommandFromResource(Long orderId, UpdateOrderResource resource){
        return new UpdateOrderCommand(orderId, resource.orderTitle(), resource.deliveryMethod(), resource.totalOrder());
    }
}
