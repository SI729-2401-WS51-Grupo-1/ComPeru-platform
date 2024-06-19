package pe.edu.upc.comperu_platform.orders.domain.services;

import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.CreateOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.DeleteOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.UpdateOrderCommand;

import java.util.Optional;

public interface OrdersCommandService {
    Long handle(CreateOrderCommand command);
    Optional<Orders> handle(UpdateOrderCommand command);
    void handle(DeleteOrderCommand command);
}
