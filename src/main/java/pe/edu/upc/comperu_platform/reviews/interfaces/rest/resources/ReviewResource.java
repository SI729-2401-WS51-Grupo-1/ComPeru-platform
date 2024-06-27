package pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources;


public record ReviewResource(Long reviewId,Long userId,Long productId, String content, double rating) {
}
