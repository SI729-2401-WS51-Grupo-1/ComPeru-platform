package pe.edu.upc.comperu_platform.reviews.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity) {
        return new ReviewResource(entity.getId(), entity.getUserId().userId(),entity.getProductId().productId(), entity.getContent(), entity.getRating().rating());
    }
}
