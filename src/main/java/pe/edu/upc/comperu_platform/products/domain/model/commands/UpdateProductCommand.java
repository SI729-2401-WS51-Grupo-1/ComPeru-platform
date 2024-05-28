package pe.edu.upc.comperu_platform.products.domain.model.commands;

import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.Price;

public record UpdateProductCommand(Long productId, String name, String description, String modelNumber, String manufacturerNumber, Price price, Boolean availability, Integer stock, Long brandId, Long categoryId) {
}
