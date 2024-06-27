package pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources;


public record CreateReviewResource(Long userId,Long productId, String content, double rating) {
}
