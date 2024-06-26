package pe.edu.upc.comperu_platform.orders.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.OrderResource;

public class OrderResourceFromEntityAssembler {

    public static OrderResource toResourceFromEntity(Orders entity){
        return new OrderResource(entity.getId(), entity.getOrderTitle(), entity.getDeliveryMethod(), entity.getTotalOrder());
    }
}
