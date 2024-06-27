package pe.edu.upc.comperu_platform.reviews.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.reviews.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(resource.userId(),resource.productId(), resource.content(), resource.rating());
    }
}
