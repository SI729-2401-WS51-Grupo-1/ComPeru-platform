package pe.edu.upc.comperu_platform.orders.interfaces.rest.resources;

public record CreateOrderResource(String orderTitle, String deliveryMethod, Long totalOrder) {
}
