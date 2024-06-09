package pe.edu.upc.comperu_platform.products.domain.model.commands;

import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.Price;

import java.util.List;

public record UpdateProductCommand(Long productId, String name, String description, String modelNumber, String manufacturerNumber, Double price, Boolean availability, Integer stock, Long brandId, Long categoryId,Long entrepreneurId, List<String> imageUrls) {
}
