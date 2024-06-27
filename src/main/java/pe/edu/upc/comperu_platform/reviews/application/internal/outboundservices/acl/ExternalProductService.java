package pe.edu.upc.comperu_platform.reviews.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.interfaces.acl.ProductContextFacade;
import pe.edu.upc.comperu_platform.reviews.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsByProductIdQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.ProductId;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewQueryService;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalProductService {

    private final ProductContextFacade productContextFacade;
    private final ReviewQueryService reviewQueryService;

    public ExternalProductService(ProductContextFacade productContextFacade, ReviewQueryService reviewQueryService) {
        this.productContextFacade = productContextFacade;
        this.reviewQueryService = reviewQueryService;
    }

    public Optional<ProductId> updateRating(Long productId){

        var query = new GetAllReviewsByProductIdQuery(productId);
        List<Review> reviews = reviewQueryService.handle(query);

       double averageRating = reviews.stream()
                .mapToDouble(Review::getRatingValue)
               .average()
                .orElse(0.0);

        var productIdOpt = productContextFacade.updateRatingInProduct(productId,averageRating);

        System.out.println(productIdOpt);

        if (productIdOpt == 0L){
            return Optional.empty();
        }

        return Optional.of(new ProductId(productIdOpt));


    }



}
