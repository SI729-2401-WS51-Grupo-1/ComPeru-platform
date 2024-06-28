package pe.edu.upc.comperu_platform.reviews.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.reviews.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.ProductId;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.UserId;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {


    @Embedded
    private UserId userId;

    private String content;

    @Embedded
    private Rating rating;

    @Embedded
    private ProductId productId;

    public Review(){
        this.content = Strings.EMPTY;
        this.rating = new Rating();
        this.productId = new ProductId();
    }

    public Review(Long userId, String content){
        this();
        this.userId= new UserId(userId);
        this.content=content;

    }

    public Review(String content, int rating){
        this.content=content;
        this.rating=new Rating(rating);
    }

    public Review(CreateReviewCommand command) {
        this();
        this.userId = new UserId(command.userId());
        this.content = command.content();
        this.rating = new Rating(command.rating());
        this.productId = new ProductId(command.productId());

    }
    public double getRatingValue() {
        return this.rating.rating();
    }

}
