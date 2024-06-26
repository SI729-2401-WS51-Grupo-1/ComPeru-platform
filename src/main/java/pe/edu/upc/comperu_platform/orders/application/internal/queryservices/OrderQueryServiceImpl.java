package pe.edu.upc.comperu_platform.orders.application.internal.queryservices;

import org.hibernate.query.Order;
import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetAllOrdersQuery;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetOrderByIdQuery;
import pe.edu.upc.comperu_platform.orders.domain.services.OrdersQueryService;
import pe.edu.upc.comperu_platform.orders.infrastructure.persistence.jpa.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements OrdersQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Orders> handle(GetOrderByIdQuery query){
        return orderRepository.findById(query.orderId());
    }

    @Override
    public List<Orders> handle(GetAllOrdersQuery query){
        return orderRepository.findAll();
    }
}
