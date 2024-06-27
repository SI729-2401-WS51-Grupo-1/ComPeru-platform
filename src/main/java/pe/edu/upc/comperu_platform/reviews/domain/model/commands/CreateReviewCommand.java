package pe.edu.upc.comperu_platform.reviews.domain.model.commands;


public record CreateReviewCommand(Long userId,Long productId, String content, double rating) {
}
