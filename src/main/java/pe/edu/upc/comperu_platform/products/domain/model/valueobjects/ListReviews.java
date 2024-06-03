package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ListReviews {

    private List<ReviewId> reviews;

    public ListReviews(){this.reviews = new ArrayList<>();}

}
