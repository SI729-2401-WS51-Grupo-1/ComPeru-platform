package pe.edu.upc.comperu_platform.reviews.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {
    private User user;

    private String content;

    private Rating rating;

    public Review(){
        this.user=new User();
        this.content = Strings.EMPTY;
        this.rating = Rating.REGULAR;
    }

    public Review(User user, String content){
        this.user=user;
        this.content=content;
        this.rating=Rating.REGULAR;
    }

    public Review(String content, Rating rating){
        this.content=content;
        this.rating=rating;
    }
}
