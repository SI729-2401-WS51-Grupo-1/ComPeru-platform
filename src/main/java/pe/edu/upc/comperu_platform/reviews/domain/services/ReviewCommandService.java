package pe.edu.upc.comperu_platform.reviews.domain.services;

import pe.edu.upc.comperu_platform.reviews.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.comperu_platform.reviews.domain.model.commands.DeleteReviewCommand;

public interface ReviewCommandService {
    Long handle(CreateReviewCommand command);
    void handle(DeleteReviewCommand command);
}
