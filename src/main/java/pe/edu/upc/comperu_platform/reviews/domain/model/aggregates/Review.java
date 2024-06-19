package pe.edu.upc.comperu_platform.reviews.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {
    private String content;

    private Rating rating;

    public Review(){
        this.content = Strings.EMPTY;
        this.rating = Rating.REGULAR;
    }
}
