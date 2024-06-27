package pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Rating(double rating) {

    public Rating{
        if(rating <0 || rating>5){
            throw new IllegalArgumentException("Rating must be value between 0 and 5");
        }
    }

    public Rating(){
        this(0.0);
    }



}
