package pe.edu.upc.comperu_platform.orders.interfaces.rest.resources;

public record OrderResource(Long id, String orderTitle, String deliveryMethod, Long totalOrder) {
}
