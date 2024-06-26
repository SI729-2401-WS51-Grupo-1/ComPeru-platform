package pe.edu.upc.comperu_platform.orders.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.CreateOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.DeleteOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.UpdateOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.services.OrdersCommandService;
import pe.edu.upc.comperu_platform.orders.infrastructure.persistence.jpa.repositories.OrderRepository;

import java.util.Optional;

@Service
public class OrderCommandServiceImpl implements OrdersCommandService {

    private final OrderRepository orderRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    @Override
    public Long handle(CreateOrderCommand command){
        if(orderRepository.existsByOrderTitle(command.orderTittle())){
            throw new IllegalArgumentException("Order with same title already exists");
        }
        var order = new Orders(command);
        try {
            orderRepository.save(order);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving order: " + e.getMessage());
        }
        return order.getId();
    }

    @Override
    public Optional<Orders> handle(UpdateOrderCommand command){
        if (orderRepository.existsByOrderTitleAndIdIsNot(command.orderTittle(), command.id()))
            throw new IllegalArgumentException("Order with same title already exists");
        var result = orderRepository.findById(command.id());
        if(result.isEmpty())
            throw new IllegalArgumentException("Order does not exist");
        var orderToUpdate = result.get();
        try{
            var updatedOrder = orderRepository.save(orderToUpdate.updateInformation(command.orderTittle(), command.deliveryMethod(), command.totalOrder()));
            return Optional.of(updatedOrder);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating order: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteOrderCommand command){
        if (!orderRepository.existsById(command.orderId())){
            throw new IllegalArgumentException("Order does not exist");
        }
        try {
            orderRepository.deleteById(command.orderId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error while deleting order: " + e.getMessage());
        }
    }



}
