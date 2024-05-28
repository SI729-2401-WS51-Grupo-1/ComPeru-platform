package pe.edu.upc.comperu_platform.products.domain.model.commands;

public record AddImageToProductCommand(Long productId, String imageName, String imageUrl) {
}
