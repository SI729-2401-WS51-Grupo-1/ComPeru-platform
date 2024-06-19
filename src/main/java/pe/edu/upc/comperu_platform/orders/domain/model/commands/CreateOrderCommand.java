package pe.edu.upc.comperu_platform.orders.domain.model.commands;

public record CreateOrderCommand(String orderTittle, String deliveryMethod, Long totalOrder) {
}
