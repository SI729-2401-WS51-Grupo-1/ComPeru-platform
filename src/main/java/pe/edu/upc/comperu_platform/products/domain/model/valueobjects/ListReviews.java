package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ListReviews {

    private final List<ReviewId> reviews;

    public ListReviews(){this.reviews = new ArrayList<>();}

}
