package pe.edu.upc.comperu_platform.reviews.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.reviews.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects.Rating;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    private String content;

    private int rating;

    public Review(){
        this.userId=new User();
        this.content = Strings.EMPTY;
        this.rating = 0;
    }

    public Review(User user, String content){
        this.userId=user;
        this.content=content;
        this.rating=0;
    }

    public Review(String content, int rating){
        this.content=content;
        this.rating=rating;
    }

    public Review(CreateReviewCommand command) {
        this();
        this.userId = command.user();
        this.content = command.content();
        this.rating = command.rating();
    }
}
