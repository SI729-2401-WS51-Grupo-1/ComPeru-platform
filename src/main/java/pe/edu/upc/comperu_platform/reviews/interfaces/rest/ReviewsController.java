package pe.edu.upc.comperu_platform.reviews.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.comperu_platform.reviews.domain.model.queries.GetReviewByIdQuery;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewCommandService;
import pe.edu.upc.comperu_platform.reviews.domain.services.ReviewQueryService;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources.CreateReviewResource;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.resources.ReviewResource;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.reviews.interfaces.rest.transform.ReviewResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Review Management Endpoints")
public class ReviewsController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    public ReviewsController(ReviewCommandService reviewCommandService, ReviewQueryService reviewQueryService) {
        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewResource>> getAllReviews() {
        var getAllReviewQuery = new GetAllReviewsQuery();
        var reviews = reviewQueryService.handle(getAllReviewQuery);
        var reviewResources = reviews.stream().map(ReviewResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reviewResources);
    }

    @PostMapping
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource createReviewResource) {
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(createReviewResource);
        var reviewId = reviewCommandService.handle(createReviewCommand);

        if (reviewId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);

        if (review.isEmpty())
            return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(review.get());
        return new ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }
}
