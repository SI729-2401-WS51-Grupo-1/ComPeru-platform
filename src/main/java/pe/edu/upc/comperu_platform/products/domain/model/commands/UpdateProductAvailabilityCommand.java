package pe.edu.upc.comperu_platform.products.domain.model.commands;

public record UpdateProductAvailabilityCommand(Long productId, Boolean availability) {
}
