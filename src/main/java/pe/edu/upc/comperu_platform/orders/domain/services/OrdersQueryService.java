package pe.edu.upc.comperu_platform.orders.domain.services;

import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetAllOrdersQuery;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetOrderByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OrdersQueryService {
    Optional<Orders> handle(GetOrderByIdQuery query);
    List<Orders> handle(GetAllOrdersQuery query);
}
