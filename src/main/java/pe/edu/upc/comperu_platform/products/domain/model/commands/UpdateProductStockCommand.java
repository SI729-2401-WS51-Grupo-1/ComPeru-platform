package pe.edu.upc.comperu_platform.products.domain.model.commands;

public record UpdateProductStockCommand(Long productId, Integer stock) {
}
