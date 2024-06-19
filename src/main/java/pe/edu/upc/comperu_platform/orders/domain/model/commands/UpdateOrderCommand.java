package pe.edu.upc.comperu_platform.orders.domain.model.commands;

public record UpdateOrderCommand(Long id, String orderTittle, String deliveryMethod, Long totalOrder ) {
}
