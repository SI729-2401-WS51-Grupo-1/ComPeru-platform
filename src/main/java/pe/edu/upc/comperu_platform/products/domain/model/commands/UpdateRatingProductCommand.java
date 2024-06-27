package pe.edu.upc.comperu_platform.products.domain.model.commands;

public record UpdateRatingProductCommand(Long productId,double newRating) {
}
