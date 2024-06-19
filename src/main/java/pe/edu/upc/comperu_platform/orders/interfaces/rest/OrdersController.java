package pe.edu.upc.comperu_platform.orders.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.DeleteOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.UpdateOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetAllOrdersQuery;
import pe.edu.upc.comperu_platform.orders.domain.model.queries.GetOrderByIdQuery;
import pe.edu.upc.comperu_platform.orders.domain.services.OrdersCommandService;
import pe.edu.upc.comperu_platform.orders.domain.services.OrdersQueryService;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.CreateOrderResource;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.OrderResource;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.resources.UpdateOrderResource;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.transform.CreateOrderCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.transform.OrderResourceFromEntityAssembler;
import pe.edu.upc.comperu_platform.orders.interfaces.rest.transform.UpdateOrderCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Orders", description = "Orders Management Endpoints")
public class OrdersController {
    private final OrdersCommandService ordersCommandService;
    private final OrdersQueryService ordersQueryService;

    public OrdersController(OrdersCommandService ordersCommandService, OrdersQueryService ordersQueryService) {
        this.ordersCommandService = ordersCommandService;
        this.ordersQueryService = ordersQueryService;
    }

    /**
     * Create new Order
     *
     */
    @PostMapping
    public ResponseEntity<OrderResource> createOrder(@RequestBody CreateOrderResource createOrderResource) {
        var createOrderCommand = CreateOrderCommandFromResourceAssembler.toCommandFromResource(createOrderResource);
        var orderId = ordersCommandService.handle(createOrderCommand);

        if (orderId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getOrderByIdQuery = new GetOrderByIdQuery(orderId);
        var orders = ordersQueryService.handle(getOrderByIdQuery);

        if(orders.isEmpty())
            return ResponseEntity.badRequest().build();
        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(orders.get());
        return new ResponseEntity<>(orderResource, HttpStatus.CREATED);
    }

    /**
     * Get a order by id
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResource> getOrderId(@PathVariable Long orderId) {
        var getOrderByIdQuery = new GetOrderByIdQuery(orderId);
        var orders = ordersQueryService.handle(getOrderByIdQuery);

        if(orders.isEmpty())
            return ResponseEntity.badRequest().build();
        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(orders.get());
        return ResponseEntity.ok(orderResource);
    }

    /**
     * Gets all the orders
     */
    @GetMapping
    public ResponseEntity<List<OrderResource>> getAllOrders() {
        var getAllOrdersQuery = new GetAllOrdersQuery();
        var orders = ordersQueryService.handle(getAllOrdersQuery);
        var orderResources = orders.stream().map(OrderResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(orderResources);
    }

    /**
     * Updates a order
     */
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResource> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderResource updateOrderResource){
        var updateCourseCommand = UpdateOrderCommandFromResourceAssembler.toCommandFromResource(orderId, updateOrderResource);
        var updatedOrder = ordersCommandService.handle(updateCourseCommand);

        if(updatedOrder.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(updatedOrder.get());
        return ResponseEntity.ok(orderResource);
    }

    /**
     * Delete a order
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId){
        var deleteOrderCommand = new DeleteOrderCommand(orderId);
        ordersCommandService.handle(deleteOrderCommand);
        return ResponseEntity.ok("Order with given id deleted");
    }



}
