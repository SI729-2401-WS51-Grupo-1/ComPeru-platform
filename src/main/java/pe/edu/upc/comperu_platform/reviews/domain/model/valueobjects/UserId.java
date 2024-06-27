package pe.edu.upc.comperu_platform.reviews.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long userId) {

    public UserId{
        if(userId <0){
            throw new IllegalArgumentException("User userid cannot be negative");
        }
    }

    public UserId(){
        this(0L);
    }


}
